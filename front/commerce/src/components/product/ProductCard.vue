<template>
  <v-card class="flex">
    <v-img
      :src="image"
      :height="height"
      cover
      class="text-white align-center"
      gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
    >
      <h1 class="text-center font-size">{{ title }}</h1>
      <div class="text-center">
        <v-btn  href="/shop" class="white--text outlined ">SHOP NOW</v-btn>
      </div>
    </v-img>
  </v-card>
</template>
<script setup>
defineProps({
  image: {
    type: String,
  },
  height: {
    type: String,
  },
  title: {
    type: String,
  }
})

</script>
<style scoped>

</style>
