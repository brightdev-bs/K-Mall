<template>
    <v-app-bar>
      <v-container>
        <v-btn href="/" class="float-left">K-MALL</v-btn>
        <v-btn class="float-right" >
          <v-badge :content="this.basketNumber">
            <v-icon size="x-large" icon="mdi-cart-outline"></v-icon>
          </v-badge>
        </v-btn>
      </v-container>
    </v-app-bar>
</template>

<script>

import {useStore} from "vuex";
import {computed} from "vue";

export default {
  setup() {
    const store = useStore();
    const basketNumber = computed(() => store.state.basketNumber);
    const increase = () => store.commit("setCounter", basketNumber.value++);

    return { basketNumber, increase }
  }
}

</script>
