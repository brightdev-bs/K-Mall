<template>
  <v-main>
    <default-header
      @updateData="updateData"
    />
    <router-view />
  </v-main>
</template>

<script>

import DefaultHeader from "@/layouts/default/Header.vue";

export default {
  components: {DefaultHeader},
  methods: {
    updateData(category) {
      console.log("updateData = ", category);
      this.$router.push(category);
    }
  }
}
</script>
