<template>
<head>
<vueper-slides
  class="no-shadow"
  :visible-slides="6"
  :arrows="false"
  :slide-ratio="1 / 4"
  :gap="3"
  :dragging-distance="70">
  <vueper-slide v-for="i in 9" :key="i" :title="i.toString()" />
</vueper-slides>
</head>
</template>

<script>
import { VueperSlides, VueperSlide } from 'vueperslides'
import 'vueperslides/dist/vueperslides.css'

export default {
  components: { VueperSlides, VueperSlide },

data: () => ({
  slides: [
    {
      title: 'Slide #1',
      content: 'The_Giving_Tree.jpg'
    }
  ]
})
}
</script>

<style scoped>

</style>