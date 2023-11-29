<template>
  <v-row>
    <v-col cols="12">
      <v-tabs
        bg-color="deep-purple-darken-4"
        center-active
        v-model="activeCategory"
      >
        <v-spacer/>
        <v-tab @click="$emit('moveToCategory', category)" v-for="category in categories">{{ category }}</v-tab>
        <v-spacer/>
      </v-tabs>
    </v-col>
  </v-row>
</template>
<script setup>

import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";

const route = useRoute();

const categories = ['Home', 'Cosmetics', 'Clothes', 'Foods', 'Books', 'Travel', 'E-Coupon'];
const activeCategory = ref('Home');

onMounted(() => {
  const categoryFromRoute = route.params.category;
  if (categories.includes(categoryFromRoute)) {
    activeCategory.value = categoryFromRoute;
  }
});
</script>
<style scoped>

</style>
