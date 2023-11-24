<template>
  <div class="form login">
    <div class="form-content">
      <header>Login</header>

      <div class="field input-field">
        <input type="email" placeholder="Email" class="input" @blur="v$.loginForm.email.$touch" v-model="loginForm.email">
        <div v-if="v$.loginForm.email.$error" class="error-message">The Format isn't correct</div>
      </div>

      <div class="field input-field">
        <input type="password" placeholder="Password" class="password" @blur="v$.loginForm.password.$touch" v-model="loginForm.password">
        <i class='bx bx-hide eye-icon'></i>
      </div>
      <div v-if="v$.loginForm.password.$error" class="error-message">Password should be longer</div>

      <div class="form-link">
        <router-link to="/password" class="forgot-pass">Forgot password?</router-link>
      </div>

      <div class="field button-field">
        <button @click="submitLoginForm()">Login</button>
      </div>


      <div class="form-link">
        <span>Don't have an account? <a class="link signup-link" @click="changeToSignupForm">Signup</a></span>
      </div>
    </div>

    <div class="line"></div>

    <SocialLoginButton :social-type="'google'" @click="loginWithSocialMedia(Constants.GOOGLE)"/>
  </div>
</template>
<script>
import {Constants} from "@/global/constants";
import SocialLoginButton from "@/components/account/SocialLoginButton.vue";
import {reactive, toRefs} from "vue";
import {email, minLength, required} from "@vuelidate/validators";
import {useVuelidate} from "@vuelidate/core";

export default {
  components: {SocialLoginButton},
  computed: {
    Constants() {
      return Constants
    }
  },
  setup () {
    const initialState = {
      loginForm: {
        email: '',
        password: '',
      },
    }

    const state = reactive({
      ...initialState,
    })

    const rules = {
      loginForm: {
        email: { required, email },
        password: { required, minLength: minLength(8)}
      }
    }

    const v$ = useVuelidate(rules, state)

    return {
      ...toRefs(state),
      state,
      v$ }
  },
  methods: {
    changeToSignupForm() {
      this.$emit('changeForm', true);
    },
    async submitLoginForm() {
      const isFormCorrect = await this.v$.$validate();
      if(isFormCorrect)
        this.$emit('update:submitLogin', this.state.loginForm)
    },
    async loginWithSocialMedia(platform) {
      this.$emit('loginWithSocialMedia', platform);
    },
  }
}
</script>
<style scoped>
.error-message {
  color: darkred;
  margin-left: 15px;
}
</style>
