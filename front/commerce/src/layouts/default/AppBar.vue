<template>
  <v-app-bar :elevation="10">
    <v-btn href="/">K-MALL</v-btn>
    <template v-slot:append>
      <v-btn-group v-if="isActive()">
        <v-btn href="/login">LOGIN</v-btn>
      </v-btn-group>
      <v-btn-group v-else>
        <v-btn href="/my-page">{{ username }}</v-btn>
        <v-btn @click="logout">logout</v-btn>
      </v-btn-group>
    </template>
  </v-app-bar>
</template>

<script setup>

import router from "@/router";

let username = '';

function isActive() {
  username = localStorage.getItem("name");
  const token = localStorage.getItem("token");
  return !username;
}

function logout() {
  localStorage.removeItem('id');
  localStorage.removeItem('name');
  localStorage.removeItem('token');
  router.go();
}

</script>
