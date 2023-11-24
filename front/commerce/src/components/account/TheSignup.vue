<template>
  <div class="form signup">
    <div class="form-content">
      <header>Signup</header>
        <div class="field input-field">
          <input type="text" placeholder="Username" class="input" @blur="v$.username.$touch" v-model="username">
          <div v-if="v$.username.$error" class="error-message">The Format isn't correct</div>
        </div>

        <div class="field input-field">
          <div class="field input-field flex">
            <input type="email" placeholder="Email" class="input" @blur="v$.email.$touch" v-model="email">
            <div v-if="v$.email.$error" class="error-message">이메일 형식이 아닙니다.</div>
          </div>
        </div>

        <div class="field input-field">
          <v-btn @click="validateEmail" :disabled="this.verified">인증하기</v-btn>
        </div>
        <LoadingAlert :loading="loading"/>

        <div class="field input-field">
          <input type="password" placeholder="Create password" class="password" @blur="v$.password.$touch" v-model="password">
          <div v-if="v$.password.$error" class="error-message">The Format isn't correct</div>
        </div>

        <div class="field input-field">
          <input type="password" placeholder="Confirm password" class="password" @blur="v$.password2.$touch" v-model="password2">
          <div v-if="v$.password2.$error" class="error-message">The Format isn't correct</div>
          <i class='bx bx-hide eye-icon'></i>
        </div>

        <div class="field button-field">
          <button @click="submitSignupForm">Signup</button>
        </div>

      <div class="form-link">
        <span>Already have an account? <a @click="toLoginForm" class="link login-link">Login</a></span>
      </div>

    </div>
  </div>
</template>
<script>
import {useAxios} from "@/composables/useAxios";
import {reactive, toRefs} from "vue";
import {email, minLength, required, sameAs} from "@vuelidate/validators";
import {useVuelidate} from "@vuelidate/core";
import router from "@/router";
import LoadingAlert from "@/components/common/LoadingAlert.vue";
export default {
  components: {LoadingAlert},
  setup () {

    const { loading, submitExecute } = useAxios(
      'account/email',
      {
        method: 'post',
      },
      {
        immediate: false,
        onSuccess: () => {
          state.verified = true;
          alert("이메일을 확인해주세요.")
        },
      },
    )

    const initialState = {
      username: '',
      email: '',
      password: '',
      password2: '',
      select: null,
      checkbox: null,
      verified: false,
      loading: loading,
      execute: submitExecute,
    };

    const state = reactive({
      ...initialState,
    })

    const rules = {
      username: { required },
      email: { required, email },
      password: { required, minLength: minLength(8)},
      password2: { required, sameAsPassword: state.password},
      verified: { sameAs: sameAs(true) }
    }

    const emailRule = {
      email: { required, email },
    }

    const v$ = useVuelidate(rules, state)
    const vEmail$ = useVuelidate(emailRule, state)

    return {
      ...toRefs(state),
      state,
      vEmail$,
      v$ }
  },
  methods: {
    async submitSignupForm() {
      const isFormCorrect = await this.v$.$validate();
      console.log(isFormCorrect)
      if(isFormCorrect) {
        const requestBody = {
          username: this.state.username,
          email: this.state.email,
          password: this.state.password
        };

        const { submitExecute } = useAxios(
          'account/signup',
          {
            method: 'post',
          },
          {
            immediate: false,
            onSuccess: () => {
              alert("회원가입되었습니다.");
              this.$router.go(0);
            },
          },
        );
        submitExecute(requestBody);
      }

    },
    toLoginForm() {
      this.$emit('changeForm', false);
    },
    async validateEmail() {
      const body = {
        "email": this.email
      }

      const isEmailForm = await this.vEmail$.$validate()
      if (isEmailForm)
        this.execute(body)
    }
  },
  watch: {
    email () {
      this.state.verified = false;
    }
  }
}
</script>
<style scoped>

</style>
