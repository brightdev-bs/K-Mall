import { createStore } from 'vuex'

export default createStore({
  state: {
    basketNumber: 0
  },
  computed: {
    increaseBasketNumber () {
      return this.state.basketNumber++;
    }
  }
})
