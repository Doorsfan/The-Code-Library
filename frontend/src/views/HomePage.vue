<template>
  <Header />
  <Article
    v-for="(articleItem, index) of allArticles"
    :key="index"
    :article="articleItem"
  />
  <Footer class="footerDiv" />
</template>
<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';
import Article from '../components/Article.vue';

import store from '../store';

export default {
  name: 'HomePage',
  components: {
    Header,
    Article,
    Footer,
  },
  beforeMount() {},
  data() {
    return {
      allArticles: [],
    };
  },
  async mounted() {
    this.allArticles = [];
    let res = await fetch('/rest/articles/', {
      method: 'GET',
    });
    let response = await res.json();
    for (let i = 0; i < response.length; i++) {
      this.allArticles.push(response[i]);
    }
    console.log(response);
    console.log(this.allArticles);
  },
  updated() {},
  unmounted() {},

  methods: {},
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Revalia&family=Roboto&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Revalia&family=Roboto:wght@300;400&display=swap');
</style>
