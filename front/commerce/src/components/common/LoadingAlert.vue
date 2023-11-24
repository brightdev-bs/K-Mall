<template>
  <v-row justify="center">
    <v-progress-circular
      v-if="loading"
      color="primary"
      indeterminate>

    </v-progress-circular>
  </v-row >
</template>

<script>

export default {
  props: {
    loading: Boolean,
  }

}
</script>

<style scoped>

</style>
