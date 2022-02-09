<template>
  <main class="app-main">
    <div class="BackDrop">
      <router-view />
    </div>
  </main>
</template>
<script>
import Header from './components/Header.vue';
import store from './store';

export default {
  name: 'App',
  components: {
    Header,
  },
  data() {
    return {};
  },
};
</script>

<style scoped></style>
<style>
* {
  margin: 0px;
  padding: 0px;
}
.app-main {
  height: 100vh;
}
.BackDrop {
  background-color: #131313;
  overflow-y: scroll;
  height: -webkit-fill-available;
}
</style>
