<template>
  <div class="media-options">
    <a href="#" class="field" :class="socialClass">
      <v-icon v-if="isFacebook" class='bx bxl-facebook facebook-icon'>mdi-facebook</v-icon>
<!--      <img v-else-if="isGoogle" :src="require('@/assets/images/google_logo.png')" alt="" class="google-img">-->
      <span>{{ buttonText }}</span>
    </a>
  </div>
</template>
<script>
export default {
  props: {
    socialType: String,
  },
  computed: {
    isFacebook() {
      return this.socialType === 'facebook';
    },
    isGoogle() {
      return this.socialType === 'google';
    },
    socialClass() {
      return this.isFacebook ? 'facebook' : 'google';
    },
    buttonText() {
      return this.isFacebook ? 'Login with Facebook' : 'Login with Google';
    },
  },
}
</script>
<style scoped>

</style>
