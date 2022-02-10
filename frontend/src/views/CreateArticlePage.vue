<template>
  <div class="profileHeader">
    <div @click="goToHomepage" class="homeDiv">
      <img class="homeIcon" src="../images/home.png" />
    </div>
    <div class="BodyBox">
      <input
        class="titleInput"
        type="text"
        placeholder="Your title.."
        v-model="wantedTitle"
      />
      <div class="AuthorText">Author</div>
      <div class="firstTagBox">
        <input type="text" placeholder="Tag 1" class="firstTagInput" />
      </div>
      <img class="profileImage" src="../images/profile.png" />
      <div class="AuthorName">John Doe</div>
      <div class="secondTagBox">
        <input
          type="text"
          placeholder="Tag 2 (Optional)"
          class="secondTagInput"
        />
      </div>
      <div class="thirdTagBox">
        <input
          type="text"
          placeholder="Tag 3 (Optional)"
          class="thirdTagInput"
        />
      </div>
      <div class="preRequisitesDiv">
        <div class="preReqText">Pre-requisites:</div>
      </div>
      <div class="reqInputOneDiv">
        <input type="text" placeholder="Pre-requisite 1" class="reqInputOne" />
        <input
          type="text"
          placeholder="Your difficulty.."
          class="difficultyInput"
        />
        <input
          type="text"
          placeholder="Your language.."
          class="languageInput"
        />
      </div>
      <div class="reqInputTwoDiv">
        <input
          type="text"
          placeholder="Pre-requisite 2 (Optional)"
          class="reqInputTwo"
        />
      </div>
      <div class="reqInputThreeDiv">
        <input
          type="text"
          placeholder="Pre-requisite 3 (Optional)"
          class="reqInputThree"
        />
      </div>
    </div>
    <div class="codeLibraryText">--=== The Code Library ===--</div>
  </div>
  <textarea
    v-model="wantedFirstDescription"
    class="firstDescriptionInput"
    type="textarea"
    rows="1"
    cols="33"
    placeholder="Your first description.."
  />
  <input type="text" class="firstTitleInput" placeholder="Your first title.." />
  <textarea
    v-model="wantedFirstSection"
    class="firstSectionInput"
    type="textarea"
    rows="1"
    cols="33"
    placeholder="Your first section of content.."
  />
  <textarea
    v-model="wantedFirstDescription"
    class="secondDescriptionInput"
    type="textarea"
    rows="1"
    cols="33"
    placeholder="Your second description.. (Optional)"
  />
  <input type="text" class="secondTitleInput" placeholder="Your second title.. (Optional)" />
  <textarea
    v-model="wantedFirstSection"
    class="secondSectionInput"
    type="textarea"
    rows="1"
    cols="33"
    placeholder="Your second section of content.. (Optional)"
  />
  <div class="fromhere"></div>
  <textarea
    v-model="wantedFirstDescription"
    class="thirdDescriptionInput"
    type="textarea"
    rows="1"
    cols="33"
    placeholder="Your third description.. (Optional)"
  />
  <input type="text" class="thirdTitleInput" placeholder="Your third title.. (Optional)" />
  <textarea
    v-model="wantedFirstSection"
    class="thirdSectionInput"
    type="textarea"
    rows="1"
    cols="33"
    placeholder="Your third section of content.. (Optional)"
  />
  <button class="publishButton" value="Publish">Publish</button>
  <Footer class="loginFooter" />
</template>
<script>
import Footer from '../components/Footer.vue';
import store from '../store';

export default {
  name: 'ChooseContentPage',
  components: {
    Footer,
  },
  data() {
    return {
      wantedTitle: '',
      wantedFirstDescription: '',
      wantedFirstSection: ''
    };
  },
  mounted() {},
  watch: {},
  methods: {
    goToHomepage() {
      this.$router.push('/');
    },
    goToMyArticles() {
      this.$router.push('/myArticles');
    },
    goToCreateNewArticle() {
      this.$router.push('/createNewArticle');
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Revalia&family=Roboto&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Revalia&family=Roboto:wght@300;400&display=swap');

* {
  outline: none;
  border: none;
}

.AuthorText {
  font-family: Roboto;
  font-style: normal;
  font-weight: normal;
  font-size: 18px;
  line-height: 21px;
  margin-left: 8px;
  margin-top: 10px;
}
.publishButton {
  position: absolute;
  top: 720px;
  left: 160px;
  width: max-content;
  border: solid 1px black;
  background-color: #C4C4C4;
  font-size: 23px;
  padding-left: 5px;
  padding-right: 5px;
  padding-top: 2px;
  padding-bottom: 2px;
}
.preRequisitesDiv {
  margin-left: 14px;
}
.AuthorName {
  position: relative;
  left: 53px;
  top: -29px;
}
.titleInput {
  width: 346px;
  margin-left: 9px;
  margin-top: 15px;
  height: 28px;
  font-size: 24px;
  padding-left: 5px;
  border: solid 1px black;
}

.firstTagBox,
.secondTagBox,
.thirdTagBox {
  background-color: black;
  width: 202px;
  border-radius: 30px;
  height: 19px;
  padding-top: 1px;
  padding-left: 12px;
  position: absolute;
  left: 165px;
  top: 123px;
}
.secondTagBox {
  top: 147px;
}
.thirdTagBox {
  top: 171px;
}
.firstSectionInput, .secondSectionInput, .thirdSectionInput{
  position: relative;
  top: 250px;
  left: 28px;
  width: 332px;
  max-width: 341px;
  padding-left: 9px;
  padding-right: 9px;
  padding-top: 5px;
  border: solid 1px black;
  padding-bottom: 20px;
  word-wrap: break-word;
}
.firstTagInput,
.secondTagInput,
.thirdTagInput {
  width: 186px;
  padding-left: 4px;
}
.profileHeader {
  display: grid;
  grid-template-columns: 20px auto;
  background-color: #61bfc5;
  height: 60px;
}

.BodyBox {
  height: 700px;
  width: 370px;
  display: block;
  margin-left: 4vw;
  margin-left: 4vw;
  margin-top: 68px;
  background-color: #61bfc5;

  border-radius: 10px;
}
.homeIcon {
  width: 30px;
  height: 30px;
  border-radius: 30px;
  margin-bottom: 14px;
}
.codeLibraryText {
  width: max-content;
  left: 45px;
  position: relative;
  top: 16px;
  font-family: Roboto;
  font-style: normal;
  font-weight: normal;
  font-size: 24px;
  line-height: 28px;
  text-align: center;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000,
    1px 1px 0 #000;
  color: #ffffff;
}

.profileImage {
  border-radius: 30px;
  width: 30px;
  height: 30px;
  margin-left: 10px;
}
.reqInputOne,
.reqInputTwo,
.reqInputThree,
.difficultyInput,
.languageInput {
  border: solid 1px black;
  margin-left: 14px;
  margin-right: 5px;
  padding-left: 5px;
  width: 197px;
  height: 18px;
}
.firstDescriptionInput, .secondDescriptionInput, .thirdDescriptionInput {
  width: 306px;
  padding-left: 8px;
  padding-top: 4px;
  padding-bottom: 34px;
  border-radius: 10px;
  border: solid 1px black;
  position: relative;
  top: 240px;
  left: 45px;
  text-align: center;
}
.secondDescriptionInput{
  margin-top: 16px;
}
.thirdDescriptionInput{
  margin-top: 16px;
}
.difficultyInput {
  position: relative;
  left: 214px;
  width: 125px;
  height: 18px;
  top: -21px;
}
.firstTitleInput, .secondTitleInput, .thirdTitleInput {
  text-align: center;
  position: relative;
  right: -37px;
  width: 330px;
  border: solid 1px black;
  top: 240px;
}
.languageInput {
  position: relative;
  left: 63px;
  width: 125px;
  height: 18px;
  top: 5px;
}
.reqInputTwo {
  position: relative;
  top: -13px;
}
.reqInputThree {
  position: relative;
  top: -4px;
}
.homeDiv {
  background-color: red;
  position: absolute;
  border-radius: 30px;
  top: 16px;
  left: 14px;
  height: 30px;
  margin-bottom: 10px;
  width: 30px;
}

.loginFooter {
  position: relative;
  top: calc(100vh - 525px);
}
</style>
