<template>
  <div id='bakery-menu'>
    <div 
        class='productCard'
        v-for="product in this.products"
        v-bind:key=product.productId>
        <product-card v-bind:productInfo="product"/>
    </div>
  </div>
</template>

<script>
import ProductCard from '../components/ProductCard.vue';

import ProductService from "../services/ProductService";

export default {
  components: { ProductCard },
    name: "BakeryStore",
    data() {
        return {
            products: [],
        }
    },

    methods: {
        getProducts() {
            ProductService.getProducts().then((response) => {
                this.products = response.data;
            });
        },
    },

    created() {
        this.getProducts();
    }

}
</script>

<style>

</style>