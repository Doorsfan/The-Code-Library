<template>
  <div class="mainDiv">
    <div class="profileHeader">
      <div @click="goToHomepage" class="homeDiv">
        <img class="homeIcon" src="../images/home.png" />
      </div>
    </div>
    <div class="BodyBox">
      <div class="titleAndEditGrid">
        <div class="SpaceBlock" />
        <div v-if="currentUsername" class="loggedInMainTitleDiv">
          {{ maintitle }}
        </div>
        <div v-if="!currentUsername" class="nonLoggedInMainTitleDiv">
          {{ maintitle }}
        </div>
        <div v-if="editMode" class="mainTitleInputDiv">
          <input
            class="mainTitleInput"
            v-if="editMode"
            type="text"
            :placeholder="maintitle"
          />
        </div>
        <div class="SpaceBlock" />
        <img
          v-if="currentUsername && !editMode"
          class="editIcon"
          src="../images/light_pen.png"
          @click="enableEditMode"
        />
        <img
          v-if="currentUsername && editMode"
          class="saveIcon"
          src="../images/floppy.png"
          @click="enableEditMode"
        />
        <div class="SpaceBlock" />
        <img
          v-if="currentUsername && !editMode"
          class="trashIcon"
          src="../images/Light_Trash.png"
        />
        <img
          v-if="currentUsername && editMode"
          class="editingTrashIcon"
          src="../images/Light_Trash.png"
        />
        <div class="SpaceBlock" />
      </div>
      <div v-if="!editMode" class="AuthorText">Author</div>
      <div v-if="editMode" class="EditAuthorText">Author</div>
      <div class="topGrid">
        <div class="SpaceBlock" />
        <img v-if="!editMode" class="authorImage" :src="authorimage" />
        <img v-if="editMode" class="editAuthorImage" :src="authorimage" />
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="authorText">{{ author }}</div>
        <div v-if="editMode" class="EditAuthorName">{{ author }}</div>
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="firstTag">{{ firstTag }}</div>
        <div v-if="editMode" class="editFirstTag">
          <input class="firstTagInput" type="text" :placeholder="firstTag" />
        </div>
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="secondTag">{{ secondTag }}</div>
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="thirdTag">{{ thirdTag }}</div>
        <div class="SpaceBlock" />
      </div>
      <div v-if="editMode" class="editSecondTag">
        <input class="secondTagInput" type="text" :placeholder="secondTag" />
      </div>
      <div v-if="editMode" class="editThirdTag">
        <input class="thirdTagInput" type="text" :placeholder="thirdTag" />
      </div>
      <div v-if="editMode" class="EditpreReqDiv">Pre-requisites:</div>
      <div class="preReqAndDifficultyGrid">
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="preReqDiv">Pre-requisites:</div>
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="difficultyDiv">
          Difficulty: {{ difficulty }}
        </div>
        <div class="SpaceBlock" />
      </div>
      <div v-if="editMode" class="editDifficultyDiv">
        <input
          class="editDifficultyInput"
          type="text"
          :placeholder="difficultyPlaceholder + difficulty"
        />
      </div>
      <div v-if="editMode" class="editLanguageDiv">
        <input
          class="editLanguageInput"
          type="text"
          :placeholder="languagePlaceholder + language"
        />
      </div>
      <div class="firstPreReqAndLanguageGrid">
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="firstPreReqDiv">{{ firstPreReq }}</div>
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="languageDiv">Language: {{ language }}</div>
        <div class="SpaceBlock" />
      </div>
      <div v-if="editMode" class="editFirstPreReqDiv">
        <input
          type="text"
          class="editFirstPreReqInput"
          :placeholder="firstPreReq"
        />
      </div>
      <div v-if="!editMode" class="secondPreReqGrid">
        <div class="SpaceBlock" />
        <div class="secondPreReqDiv">{{ secondPreReq }}</div>
        <div class="SpaceBlock" />
      </div>
      <div v-if="editMode" class="editSecondPreReqDiv">
        <input
          type="text"
          class="editSecondPreReqInput"
          :placeholder="secondPreReq"
        />
      </div>
      <div v-if="!editMode" class="thirdPreReqGrid">
        <div class="SpaceBlock" />
        <div class="thirdPreReqDiv">{{ thirdPreReq }}</div>
        <div class="SpaceBlock" />
      </div>
      <div v-if="editMode" class="editThirdPreReqDiv">
        <input
          type="text"
          class="editThirdPreReqInput"
          :placeholder="thirdPreReq"
        />
      </div>
      <div class="firstDescription">
        {{ firstdescription }}
      </div>
      <div class="firstTitle">
        {{ firsttitle }}
      </div>
      <div class="firstsection">
        {{ firstsection }}
      </div>
      <div v-if="seconddescription.length > 0" class="secondDescription">
        {{ seconddescription }}
      </div>
      <div v-if="secondtitle.length > 0" class="secondTitle">
        {{ secondtitle }}
      </div>
      <div v-if="thirdsection.length > 0" class="thirdsection">
        {{ secondsection }}
      </div>
      <div v-if="thirddescription.length > 0" class="thirdDescription">
        {{ thirddescription }}
      </div>
      <div v-if="thirdtitle.length > 0" class="thirdTitle">
        {{ thirdtitle }}
      </div>
      <div v-if="thirdsection.length > 0" class="thirdsection">
        {{ thirdsection }}
      </div>
      <div class="bigGrid">
        <div clas="SpaceBlock" />
        <div class="likesGrid">
          <div class="SpaceBlock" />
          <div class="likesNumber">
            {{ likes }}
          </div>
          <div class="SpaceBlock" />
          <img
            @click="likeArticle"
            class="likesIcon"
            src="../images/up_arrow.png"
          />
          <div class="SpaceBlock" />
        </div>
        <div clas="SpaceBlock" />
        <div class="dislikesGrid">
          <div class="SpaceBlock" />
          <div class="dislikesNumber">
            {{ dislikes }}
          </div>
          <div class="SpaceBlock" />
          <img
            @click="dislikeArticle"
            class="dislikesIcon"
            src="../images/down_arrow.png"
          />
          <div class="SpaceBlock" />
        </div>
        <div clas="SpaceBlock" />
        <div class="commentsGrid">
          <div class="SpaceBlock" />
          <div class="commentsNumber">
            {{ comments }}
          </div>
          <div class="SpaceBlock" />
          <img class="commentIcon" src="../images/comment.png" />
          <div class="SpaceBlock" />
        </div>
        <div class="SpaceBlock" />
      </div>
    </div>
    <Footer class="loginFooter" />
  </div>
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
          : null,
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
      thirdPreReq: '',
      firstdescription: '',
      firsttitle: '',
      firstsection: '',
      seconddescription: '',
      secondtitle: '',
      secondsection: '',
      thirddescription: '',
      thirdtitle: '',
      thirdsection: '',
      likes: 0,
      dislikes: 0,
      comments: 0,
      difficultyPlaceholder: 'Difficulty: ',
      languagePlaceholder: 'Language: ',
      editMode: false,
    };
  },
  async mounted() {
    let res = await fetch('/rest/articles/' + this.$route.params.id, {
      method: 'GET',
    });
    let response = await res.json();
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
    this.firstdescription = response.firstdescription;
    this.firsttitle = response.firsttitle;
    this.firstsection = response.firstsection;
    this.seconddescription = response.seconddescription;
    this.secondtitle = response.secondtitle;
    this.secondsection = response.secondcontent;
    this.thirddescription = response.thirddescription;
    this.thirdtitle = response.thirdtitle;
    this.thirdsection = response.thirdsection;
    this.likes = response.likes;
    this.dislikes = response.dislikes;
    this.comments = 0;
  },
  watch: {},
  methods: {
    async dislikeArticle() {
      if (localStorage.getItem('username')) {
        let myArticle = {
          maintitle: this.maintitle,
          authorimage: this.authorimage,
          author: this.author,
          firsttag: this.firstTag,
          secondtag: this.secondTag,
          thirdtag: this.thirdTag,
          difficulty: this.difficulty,
          firstprerequisite: this.firstPreReq,
          language: this.language,
          secondprerequisite: this.secondPreReq,
          thirdprerequisite: this.thirdPreReq,
          firstdescription: this.firstdescription,
          firsttitle: this.firsttitle,
          firstsection: this.firstsection,
          seconddescription: this.seconddescription,
          secondtitle: this.secondtitle,
          secondcontent: this.secondsection,
          thirddescription: this.thirddescription,
          thirdtitle: this.thirdtitle,
          thirdsection: this.thirdsection,
          likes: this.likes,
          dislikes: this.dislikes,
          comments: 0,
        };
        let res = await fetch(
          '/rest/articles/dislikeArticle/' + this.$route.params.id,
          {
            method: 'PUT',
            body: JSON.stringify(myArticle),
          }
        );
        let response = await res.json();
        this.dislikes = response;

        let secondres = await fetch(
          '/rest/dislikes/' +
            localStorage.getItem('userid') +
            '/' +
            this.$route.params.id,
          {
            method: 'GET',
          }
        );
      } else {
        alert('You have to be logged in to dislike Articles.');
      }
    },
    enableEditMode() {
      this.editMode = true;
    },
    async likeArticle() {
      if (localStorage.getItem('username')) {
        let myArticle = {
          maintitle: this.maintitle,
          authorimage: this.authorimage,
          author: this.author,
          firsttag: this.firstTag,
          secondtag: this.secondTag,
          thirdtag: this.thirdTag,
          difficulty: this.difficulty,
          firstprerequisite: this.firstPreReq,
          language: this.language,
          secondprerequisite: this.secondPreReq,
          thirdprerequisite: this.thirdPreReq,
          firstdescription: this.firstdescription,
          firsttitle: this.firsttitle,
          firstsection: this.firstsection,
          seconddescription: this.seconddescription,
          secondtitle: this.secondtitle,
          secondcontent: this.secondsection,
          thirddescription: this.thirddescription,
          thirdtitle: this.thirdtitle,
          thirdsection: this.thirdsection,
          likes: this.likes,
          dislikes: this.dislikes,
          comments: 0,
        };
        let res = await fetch(
          '/rest/articles/likeArticle/' + this.$route.params.id,
          {
            method: 'PUT',
            body: JSON.stringify(myArticle),
          }
        );
        let response = await res.json();
        this.likes = response;

        let secondres = await fetch(
          '/rest/likes/' +
            localStorage.getItem('userid') +
            '/' +
            this.$route.params.id,
          {
            method: 'GET',
          }
        );
      } else {
        alert('You have to be logged in to Like Articles.');
      }
    },
    goToHomepage() {
      this.$router.push('/');
    },
    goToMyArticles() {
      this.$router.push('/myArticles');
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

.titleAndEditGrid {
  display: grid;
  grid-template-columns: auto max-content auto max-content 5px max-content 15px;
}

.trashIcon {
  width: 25px;
  height: 25px;
  margin-top: 2px;
}
.editingTrashIcon {
  width: 25px;
  height: 25px;
  margin-top: 2px;
  position: relative;
  right: 20px;
  top: 1px;
}
.editIcon {
  width: 22px;
  height: 22px;
  margin-top: 4px;
}
.saveIcon {
  width: 25px;
  height: 25px;
  margin-top: 4px;
  position: relative;
  right: 40px;
}
.firstTagInput,
.secondTagInput,
.thirdTagInput {
  padding-left: 5px;
  margin-left: 5px;
  width: 180px;
}
.mainDiv {
  height: 100%;
  background-color: #131313;
}
.firstDescription,
.secondDescription {
  background-color: white;
  width: 314px;
  margin-left: auto;
  margin-right: auto;
  border: solid 1px black;
  border-radius: 10px;
  text-align: center;
  margin-top: 10px;
}

.bigGrid {
  display: grid;
  width: 100%;
  grid-template-columns: auto max-content auto max-content auto max-content auto max-content auto;
  position: relative;
  top: -2px;
}

.likesIcon,
.dislikesIcon,
.commentIcon {
  width: 20px;
  height: 20px;
  border-radius: 30px;
  margin-top: 0px;
}
.editLanguageInput {
  padding-left: 5px;
}
.likesNumber,
.dislikesNumber,
.commentsNumber {
  margin-top: 2px;
}

.bigGrid {
  background-color: #61bfc5;
  margin-top: 25px;
}
.likesGrid,
.dislikesGrid,
.commentsGrid {
  display: grid;
  grid-template-columns: 12px max-content 3px max-content 3px max-content 3px;
}

.firstTitle,
.secondTitle {
  width: 100%;
  text-align: center;
  margin-top: 5px;
  text-decoration: underline;
  margin-bottom: 4px;
}

.firstsection,
.secondsection {
  background-color: white;
  width: 367px;
  margin-left: auto;
  margin-right: auto;
  padding-left: 13px;
  border: solid 1px black;
}
.editDifficultyDiv {
  position: relative;
  right: -232px;
  width: 125px;
  top: -27px;
}
.editLanguageDiv {
  position: relative;
  right: -232px;
  width: 125px;
  top: -25px;
}
.editDifficultyInput {
  padding-left: 5px;
}
.EditAuthorName {
  position: relative;
  top: 30px;
}
.editFirstPreReqDiv {
  position: relative;
  left: 20px;
  top: -75px;
}
.editSecondPreReqDiv{
  position: relative;
  left: 20px;
  top: -73px;
}
.editThirdPreReqDiv{
  position: relative;
  left: 20px;
  top: -71px;
}
.editSecondPreReqInput, .editThirdPreReqInput, .editFirstPreReqInput{
  padding-left: 5px;
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
.EditAuthorText {
  font-family: Roboto;
  font-style: normal;
  font-weight: normal;
  font-size: 18px;
  line-height: 21px;
  margin-left: 12px;
  position: relative;
  top: 20px;
}
.preReqDiv {
  margin-left: 20px;
}
.EditpreReqDiv {
  margin-left: 20px;
  position: relative;
  top: -35px;
}
.loggedInMainTitleDiv {
  width: 100%;
  text-align: center;
  padding-top: 5px;
  margin-left: 30px;
}
.mainTitleInputDiv {
  margin-left: -60px;
  margin-top: 7px;
  border: solid 1px black;
  width: 290px;
}

.mainTitleInput {
  padding-left: 5px;
  width: 290px;
}
.nonLoggedInMainTitleDiv {
  width: 100%;
  text-align: center;
  padding-top: 5px;
}
.authorImage {
  width: 40px;
  height: 40px;
  border-radius: 30px;
}
.editAuthorImage {
  width: 40px;
  height: 40px;
  border-radius: 30px;
  margin-top: 20px;
  margin-left: 0px;
}
.topGrid {
  display: grid;
  grid-template-columns: auto max-content auto max-content auto max-content auto max-content auto max-content auto;
}

.preReqAndDifficultyGrid {
  display: grid;
  grid-template-columns: auto max-content auto max-content auto;
}

.firstPreReqAndLanguageGrid {
  display: grid;
  grid-template-columns: 85px max-content 133px max-content auto;
  margin-top: 13px;
}

.secondPreReqGrid,
.thirdPreReqGrid {
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
  height: max-content;
  width: 390px;
  display: block;
  margin-left: 3vw;
  margin-left: 3vw;
  margin-top: 68px;
  background-color: #61bfc5;
  position: relative;
  top: -55px;
  border-radius: 10px;
  padding-bottom: 28px;
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
  height: max-content;
}

.languageDiv {
  position: absolute;
  left: 233px;
}
.profileImage {
  border-radius: 30px;
  width: 30px;
  height: 30px;
  margin-left: 10px;
}

.authorText {
  margin-top: 10px;
}
.firstTag,
.secondTag,
.thirdTag {
  margin-top: 10px;
  color: white;
  background-color: black;
  height: 20px;
  padding-left: 3px;
  padding-right: 3px;
  border-radius: 10px;
}

.editFirstTag,
.editSecondTag,
.editThirdTag {
  color: white;
  background-color: black;
  height: 20px;
  padding-left: 5px;
  padding-right: 3px;
  border-radius: 10px;
  width: 200px;
}
.editFirstTag {
  position: relative;
  top: 2px;
  left: -2px;
}
.editSecondTag {
  position: relative;
  top: -30px;
  left: 125px;
}
.editThirdTag {
  position: relative;
  top: -22px;
  left: 125px;
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
  top: calc(100vh - 532px);
}
</style>
