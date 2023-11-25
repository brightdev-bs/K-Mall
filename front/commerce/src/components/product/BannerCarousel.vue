<template>
  <v-carousel-item
    :src="image"
    cover
  >
    <v-row
      class="fill-height"
      align="center"
      justify="center"
    >
      <div class="text-h4 text-white pl-5 pr-5 hidden-sm-only"><strong>Welcome to K-MALL</strong></div><br/>
    </v-row>
  </v-carousel-item>
</template>
<script setup>
defineProps({
  image: {
    Type: String,
  }
})

</script>
<style scoped>

</style>
