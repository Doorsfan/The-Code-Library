<template>
  <Header />
  <Footer class="footerDiv" />
</template>
<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';

import store from '../store';

export default {
  name: 'HomePage',
  components: {
    Header,
    Footer,
  },
  beforeMount() {},
  data() {
    return {};
  },
  async mounted() {},
  updated() {},
  unmounted() {},

  methods: {},
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Revalia&family=Roboto&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Revalia&family=Roboto:wght@300;400&display=swap');
</style>
