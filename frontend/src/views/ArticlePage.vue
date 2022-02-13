<template>
  <div class="profileHeader">
    <div @click="goToHomepage" class="homeDiv">
      <img class="homeIcon" src="../images/home.png" />
    </div>
  </div>
  <div class="BodyBox">
    <div class="titleBox">{{maintitle}}</div>
    <div class="AuthorText">Author</div>
    <div class="topGrid">
      <div class="SpaceBlock" />
      <img class="authorImage" :src="authorimage" />
      <div class="SpaceBlock" />
      <div class="authorText">{{author}}</div>
      <div class="SpaceBlock" />
      <div class="firstTag">{{firstTag}}</div>
      <div class="SpaceBlock" />
      <div class="secondTag">{{secondTag}}</div>
      <div class="SpaceBlock" />
      <div class="thirdTag">{{thirdTag}}</div>
      <div class="SpaceBlock" />
    </div>
    <div class="preReqAndDifficultyGrid">
      <div class="SpaceBlock" />
      <div class="preReqDiv">Pre-requisites:</div>
      <div class="SpaceBlock" />
      <div class="difficultyDiv">Difficulty: {{difficulty}}</div>
      <div class="SpaceBlock" />
    </div>
    <div class="firstPreReqAndLanguageGrid">
      <div class="SpaceBlock" />
      <div class="firstPreReqDiv">{{firstPreReq}}</div>
      <div class="SpaceBlock" />
      <div class="languageDiv">Language: {{language}}</div>
      <div class="SpaceBlock" />
    </div>
    <div class="secondPreReqGrid">
      <div class="SpaceBlock" />
      <div class="secondPreReqDiv">{{secondPreReq}}</div>
      <div class="SpaceBlock" />
    </div>
    <div class="thirdPreReqGrid">
      <div class="SpaceBlock" />
      <div class="thirdPreReqDiv">{{thirdPreReq}}</div>
      <div class="SpaceBlock" />
    </div>
  </div>
  <Footer class="loginFooter" />
</template>
<script>
import Footer from '../components/Footer.vue';
import store from '../store';

export default {
  name: 'ArticlePage',
  components: {
    Footer,
  },
  data() {
    return {
      currentUsername:
        localStorage.getItem('username') != null
          ? localStorage.getItem('username')
          : 'John Doe',
      currentProfile:
        localStorage.getItem('profileURL') != null
          ? localStorage.getItem('profileURL')
          : '../images/profile.png',
      maintitle: '',
      authorimage: '',
      author: '',
      firstTag: '',
      secondTag: '',
      thirdTag: '',
      difficulty: '',
      firstPreReq: '',
      language: '',
      secondPreReq: '',
      thirdPreReq: ''
    };
  },
  async mounted() {
    console.log(this.$route.params.id)
    let res = await fetch('/rest/articles/' + this.$route.params.id, {
        method: 'GET'
      });
    let response = await res.json();
    console.log(response.maintitle);
    this.maintitle = response.maintitle;
    this.authorimage = response.authorimage;
    this.author = response.author;
    this.firstTag = response.firsttag;
    this.secondTag = response.secondtag;
    this.thirdTag = response.thirdtag;
    this.difficulty = response.difficulty;
    this.firstPreReq = response.firstprerequisite;
    this.language = response.language;
    this.secondPreReq = response.secondprerequisite;
    this.thirdPreReq = response.thirdprerequisite;

  },
  watch: {},
  methods: {
    async publishArticle() {
      if (
        this.wantedMainTitle.length == 0 ||
        this.wantedFirstTag.length == 0 ||
        this.wantedFirstPreReq.length == 0 ||
        this.wantedDifficulty.length == 0 ||
        this.wantedLanguage.length == 0 ||
        this.wantedFirstDescription.length == 0 ||
        this.wantedFirstTitle.length == 0 ||
        this.wantedFirstSection.length == 0
      ) {
        alert('All non-optional fields are required to be filled out.');
        return;
      } else {
        let newArticle = {
          maintitle: this.wantedMainTitle,
          author: localStorage.getItem('username'),
          firsttag: this.wantedFirstTag,
          secondtag: this.wantedSecondTag,
          thirdtag: this.wantedThirdTag,
          firstprerequisite: this.wantedFirstPreReq,
          secondprerequisite: this.wantedSecondPreReq,
          thirdprerequisite: this.wantedThirdPreReq,
          difficulty: this.wantedDifficulty,
          language: this.wantedLanguage,
          firstdescription: this.wantedFirstDescription,
          firsttitle: this.wantedFirstTitle,
          firstsection: this.wantedFirstSection,
          seconddescription: this.wantedSecondDescription,
          secondtitle: this.wantedSecondTitle,
          secondcontent: this.wantedSecondSection,
          thirddescription: this.wantedThirdDescription,
          thirdtitle: this.wantedThirdTitle,
          thirdsection: this.wantedThirdSection,
          authorimage: localStorage.getItem('profileURL'),
        };

        let res = await fetch('/rest/articles/publish', {
          method: 'POST',
          body: JSON.stringify(newArticle),
        });

        let response = await res.json();
        this.$router.push('/');
      }
    },
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
  overflow-x: clip;
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

.authorImage {
  width: 40px;
  height: 40px;
  border-radius: 30px;
}

.topGrid {
  display: grid;
  grid-template-columns: auto max-content auto max-content auto max-content auto max-content auto max-content auto;
}

.preReqAndDifficultyGrid{
  display: grid;
  grid-template-columns: auto max-content auto max-content auto;
}

.firstPreReqAndLanguageGrid{
  display: grid;
  grid-template-columns: 85px max-content 133px max-content auto;
  margin-top: 13px;
}

.secondPreReqGrid, .thirdPreReqGrid{
  display: grid;
  grid-template-columns: 85px max-content;
}
.profileHeader {
  display: grid;
  grid-template-columns: 20px auto;
  background-color: #61bfc5;
  height: 60px;
}

.BodyBox {
  height: 700px;
  width: 390px;
  display: block;
  margin-left: 3vw;
  margin-left: 3vw;
  margin-top: 68px;
  background-color: #61bfc5;
  position: relative;
  top: -55px;
  border-radius: 10px;
}
.homeIcon {
  width: 30px;
  height: 30px;
  border-radius: 30px;
  margin-bottom: 14px;
}
.titleBox{
  margin-left: auto;
  margin-right: auto;
  width: max-content;
  font-size: 24px;
  font-size: bold;
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
  height: max-content;
}

.languageDiv{
  position: absolute;
  left: 233px;
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
.authorText{
  margin-top: 10px;
}
.firstTag, .secondTag, .thirdTag {
  margin-top: 10px;
  color: white;
  background-color: black;
  height: 20px;
  padding-left: 3px;
  padding-right: 3px;
  border-radius: 10px;
}
.firstDescriptionInput,
.secondDescriptionInput,
.thirdDescriptionInput {
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
.secondDescriptionInput {
  margin-top: 16px;
}
.thirdDescriptionInput {
  margin-top: 16px;
}
.difficultyInput {
  position: relative;
  left: 214px;
  width: 125px;
  height: 18px;
  top: -21px;
}
.firstTitleInput,
.secondTitleInput,
.thirdTitleInput {
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
.reqInputOne {
  position: relative;
  top: 0px;
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
