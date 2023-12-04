<template>
    <v-app-bar>
      <v-container>
        <v-btn href="/" class="float-left">K-MALL</v-btn>
        <v-btn class="float-right" >
          <v-badge :content="numberOfProductInCart">
            <v-icon size="x-large" icon="mdi-cart-outline"></v-icon>
          </v-badge>
        </v-btn>
      </v-container>
    </v-app-bar>
</template>

<script>

export default {
  data() {
    return {
      numberOfProductInCart: 0
    }
  }
}
</script>
