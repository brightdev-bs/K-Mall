<template>
  <v-carousel hide-delimiters>
    <BannerCarousel :image="slides[0]"/>
  </v-carousel>

  <v-row class="mt-2">
    <v-col>
      <BannerCard :height="400" :image="middle[0]" :title="'ON SALE'"/>
    </v-col>
    <v-col>
      <BannerCard :height="400" :image="middle[1]" :title="'New Arrivals'"/>
    </v-col>
  </v-row>


  <v-row class="mt-2">
    <v-col>
      <BannerCard :height="300" :image="deals[0]" :title="'K-Food'"/>
    </v-col>
    <v-col>
      <BannerCard :height="300" :image="deals[1]" :title="'K-Beauty'"/>
    </v-col>
    <v-col>
      <BannerCard :height="300" :image="deals[2]" :title="'K-POP GOODS'"/>
    </v-col>
  </v-row>

  <CSBanner/>
</template>
<script>

import CSBanner from "@/components/common/CSBanner.vue";
import ProductCard from "@/components/product/ProductCard.vue";
import BannerCarousel from "@/components/product/BannerCarousel.vue";
import kfood from "@/assets/img/home/kfood.jpeg";
import beauty from "@/assets/img/home/kbeauty.jpeg";
import kpop from "@/assets/img/home/kpop.jpeg";
import sale from "@/assets/img/home/sale.jpeg";
import clothes from "@/assets/img/home/clothes.jpg";
import slider1 from "@/assets/img/home/slider1.jpg";

export default {

  components: {CSBanner, BannerCard: ProductCard, BannerCarousel},
  setup() {
    const getImageUrl = (name) => {
      return new URL(`@/assets/img/home/${name}`, import.meta.url).href
    }
    return { getImageUrl }
  },
  data () {
    return {
      deals: [
        kfood,
        beauty,
        kpop,
      ],
      middle: [
        sale,
        clothes,
      ],
      slides: [
        slider1,
      ],
    }
  },
}
</script>
<style scoped>

</style>
