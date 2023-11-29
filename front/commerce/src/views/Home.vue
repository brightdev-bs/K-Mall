<template>

  <div class="ml-3 mr-3">


    <HomeMain v-if="isHome"/>

  </div>
</template>

<script>
import HomeMain from "@/components/HomeMain.vue";
export default {
  data() {
    return {
      isHome: true,
    }
  },
  components: {HomeMain },
}
</script>
<style>

</style>

