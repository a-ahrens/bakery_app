<template>
  <div id='product_container'>
    <h5>{{productInfo.productName}}</h5>
    <span>{{productInfo.description}}</span> <br>
    <span>${{productInfo.price}}</span> <br>
    <img id='product-image' :src="productInfo.imageUrl" alt="">
  </div>
</template>

<script>
export default {
    name: 'ProductCard',
    props: {
        productInfo: {
            type: Object,
            required: true
        }
    }

}
</script>

<style>
    #product-image {
        max-width: 100px;
        height: auto;
    }
</style>