<template>
  <div
    v-if="!$route.path.includes('/login')"
    class="ml-3 mr-3"
  >
    <SearchBar
      @submit="searchProduct"
    />
    <HorizontalCategory
      @move-to-category="moveToCategory"
      @login="moveToLogin"
    />


  </div>
</template>
<script>
import SearchBar from "@/components/product/SearchBar.vue";
import HorizontalCategory from "@/components/product/HorizontalCategory.vue";

export default {
  components: {HorizontalCategory, SearchBar},
  methods: {
    searchProduct(keyword) {
      console.log(keyword);
    },
    moveToCategory(category) {
      console.log(category)
      category = category.toLowerCase();
      if (category === 'home') {
        this.$emit('updateData', "/");
      } else {
        this.$emit('updateData', category);
        // Todo: 데이터 업데이트
      }
    },
    moveToLogin() {
      this.$emit()
    }
  }

}
</script>
<style scoped>

</style>
