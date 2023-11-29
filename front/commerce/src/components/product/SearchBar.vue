<template>
  <v-row justify="center">
    <v-col cols="10">
      <v-text-field
        v-model="searchInput"
        label="Search"
        prepend-inner-icon="mdi-text-short"
        variant="outlined"
        @keyup.enter="searchProduct"
        hide-details
      >

        <template v-slot:append>
          <v-tooltip location="bottom">
            <template v-slot:activator="{ props }">
              <v-icon @click="searchProduct" v-bind="props" icon="mdi-magnify"></v-icon>
            </template>
          </v-tooltip>
        </template>
      </v-text-field>
    </v-col>
  </v-row>

</template>
<script setup>
import {ref} from "vue";

const emit = defineEmits(['submit'])

const searchInput = ref('');

const searchProduct = () => {
  emit('submit', searchInput.value);
};

</script>
<style scoped>

</style>
