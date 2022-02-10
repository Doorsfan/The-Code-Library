<template>
  <div class="backgroundDiv">
    <div class="upperGrid">
      <img class="homeIcon" src="../images/home.png" />
      <div class="codeTextDiv">
        <p class="libraryText">--=== The Code Library ===--</p>
      </div>
      <div v-if="!isLoggedIn" class="loginDiv">
        <router-link to="/login">
          <button value="login" class="loginButton">Login</button>
        </router-link>
      </div>
      <div v-if="isLoggedIn" class="profileURL">
        <img v-if="profileURL.length > 0" class="profileImage" :src="profileURL" />
        <img v-if="profileURL.length == 0" class="profileImage" src="../images/profile.png" />
        <div @click="logout" class="logoutDiv">Log out</div>
      </div>

      <div class="searchDiv">
        <input class="searchInput" placeholder="Search.." type="text" />
        <img class="glassIcon" src="../images/glass.png" />
      </div>
    </div>
  </div>
</template>
<script>
import store from '../store';

export default {
  name: 'Header',
  emits: [],
  data() {
    return {
      isLoggedIn: false,
      profileURL: '',
    };
  },

  async mounted() {
    if (localStorage.getItem('username') != null) {
      this.isLoggedIn = true;
      this.profileURL = localStorage.getItem('profileURL');
    }
  },

  methods: {
    async logout() {
      localStorage.removeItem('username');
      localStorage.removeItem('profileURL');
      this.isLoggedIn = false;
      this.profileURL = '';
      this.$router.push('/');
    },
  },
};
</script>

<style scoped>
* {
  font-family: 'Roboto', sans-serif;
}
.logoutDiv {
  width: max-content;
  position: absolute;
  right: 2px;
  top: 60px;
  background-color: white;
  border-radius: 10px;
  padding-left: 3px;
  padding-right: 3px;
  border: solid 0.6px black;
}
.upperGrid {
  background-color: rgb(97, 191, 197);
  display: grid;
  grid-template-columns: 47px auto 52px;
}
.lowerGrid {
  background-color: rgb(97, 191, 197);
}
.codeTextDiv {
  font-family: Roboto;
  font-style: normal;
  font-weight: normal;
  font-size: 24px;
  line-height: 28px;
  text-align: center;
  color: #ffffff;
  padding-top: 16px;
}
.loginButton,
.profileImage {
  background: #c4c4c4;
  border: 0.7px solid #000000;
  box-sizing: border-box;
  border-radius: 30px;
  width: 45px;
  height: 45px;
  margin-top: 11px;
}
.homeIcon {
  height: 30px;
  width: 30px;
  border-radius: 30px;
  margin-left: 12px;
  margin-top: 16px;
}
.searchInput {
  border-radius: 10px;
  border: solid 0.3px black;
  padding-left: 5px;
  width: 140px;
  margin-left: 32vw;
  margin-bottom: 3px;
  display: inline-block;
  margin-top: 16px;
}
.glassIcon {
  position: relative;
  top: -30px;
  left: 70vw;
  width: 30px;
  border-radius: 10px;
  border: solid 2px #c4c4c4;
  outline: solid 1px black;
}
.libraryText {
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000,
    1px 1px 0 #000;
}
</style>
