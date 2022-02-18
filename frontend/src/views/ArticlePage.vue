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
            v-model="wantedMainTitle"
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
          @click="saveChanges"
        />
        <div class="SpaceBlock" />
        <img
          v-if="currentUsername && !editMode"
          class="trashIcon"
          src="../images/Light_Trash.png"
          @click="deleteArticle"
        />
        <img
          v-if="currentUsername && editMode"
          class="editingTrashIcon"
          src="../images/Light_Trash.png"
          @click="deleteArticle"
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
          <input
            class="firstTagInput"
            v-model="wantedFirstTag"
            type="text"
            :placeholder="firstTag"
          />
        </div>
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="secondTag">{{ secondTag }}</div>
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="thirdTag">{{ thirdTag }}</div>
        <div class="SpaceBlock" />
      </div>
      <div v-if="editMode" class="editSecondTag">
        <input
          class="secondTagInput"
          v-model="wantedSecondTag"
          type="text"
          :placeholder="secondTag"
        />
      </div>
      <div v-if="editMode" class="editThirdTag">
        <input
          class="editThirdTagInput"
          v-model="wantedThirdTag"
          type="text"
          :placeholder="thirdTag"
          v-if="editMode"
        />
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

      <input
        class="editDifficultyInput"
        type="text"
        v-if="editMode"
        :placeholder="difficultyPlaceholder + difficulty"
        v-model="wantedDifficulty"
      />

      <div v-if="editMode" class="editLanguageDiv">
        <input
          class="editLanguageInput"
          type="text"
          :placeholder="languagePlaceholder + language"
          v-model="wantedLanguage"
        />
      </div>
      <div class="firstPreReqAndLanguageGrid">
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="firstPreReqDiv">{{ firstPreReq }}</div>
        <div class="SpaceBlock" />
        <div v-if="!editMode" class="languageDiv">Language: {{ language }}</div>
        <div class="SpaceBlock" />
      </div>

      <input
        type="text"
        class="editFirstPreReqInput"
        :placeholder="firstPreReq"
        v-model="wantedFirstPreReq"
        v-if="editMode"
      />

      <div v-if="!editMode" class="secondPreReqGrid">
        <div class="SpaceBlock" />
        <div class="secondPreReqDiv">{{ secondPreReq }}</div>
        <div class="SpaceBlock" />
      </div>

      <input
        type="text"
        class="editSecondPreReqInput"
        :placeholder="secondPreReq"
        v-model="wantedSecondPreReq"
        v-if="editMode"
      />

      <div v-if="!editMode" class="thirdPreReqGrid">
        <div class="SpaceBlock" />
        <div class="thirdPreReqDiv">{{ thirdPreReq }}</div>
        <div class="SpaceBlock" />
      </div>

      <input
        type="text"
        class="editThirdPreReqInput"
        :placeholder="thirdPreReq"
        v-model="wantedThirdPreReq"
        v-if="editMode"
      />

      <div v-if="!editMode" class="firstDescription">
        {{ firstdescription }}
      </div>
      <textarea
        v-if="editMode"
        name="yourReply"
        class="editFirstDescription"
        rows="5"
        cols="33"
        :placeholder="firstdescription"
        v-model="wantedFirstDescription"
      />
      <div v-if="!editMode" class="firstTitle">
        {{ firsttitle }}
      </div>
      <div v-if="editMode" class="editFirstTitle">
        <input
          type="text"
          :placeholder="firsttitle"
          class="editFirstTitleInput"
          v-model="wantedFirstTitle"
        />
      </div>
      <div v-if="!editMode" class="firstsection">
        {{ firstsection }}
      </div>
      <textarea
        v-if="editMode"
        class="editFirstSection"
        rows="5"
        cols="33"
        :placeholder="firstsection"
        v-model="wantedFirstSection"
      />
      <div
        v-if="seconddescription.length > 0 && !editMode"
        class="secondDescription"
      >
        {{ seconddescription }}
      </div>
      <textarea
        v-if="editMode && seconddescription.length > 0"
        name="yourReply"
        class="editSecondDescription"
        rows="5"
        cols="33"
        :placeholder="seconddescription"
        v-model="wantedSecondDescription"
      />
      <div v-if="secondtitle.length > 0 && !editMode" class="secondTitle">
        {{ secondtitle }}
      </div>
      <div v-if="editMode && secondtitle.length > 0" class="editSecondTitle">
        <input
          type="text"
          :placeholder="secondtitle"
          class="editSecondTitleInput"
          v-model="wantedSecondTitle"
        />
      </div>
      <div v-if="secondsection.length > 0 && !editMode" class="secondsection">
        {{ secondsection }}
      </div>
      <textarea
        v-if="editMode"
        class="editSecondSection"
        rows="5"
        cols="33"
        :placeholder="secondsection"
        v-model="wantedSecondSection"
      />
      <div
        v-if="thirddescription.length > 0 && !editMode"
        class="thirdDescription"
      >
        {{ thirddescription }}
      </div>
      <textarea
        v-if="editMode"
        class="editThirdDescription"
        rows="5"
        cols="33"
        :placeholder="thirddescription"
        v-model="wantedThirdDescription"
      />
      <div v-if="thirdtitle.length > 0 && !editMode" class="thirdTitle">
        {{ thirdtitle }}
      </div>
      <div v-if="editMode" class="editThirdTitle">
        <input
          type="text"
          :placeholder="thirdtitle"
          v-model="wantedThirdTitle"
          class="editThirdTitleInput"
        />
      </div>
      <div v-if="thirdsection.length > 0 && !editMode" class="thirdsection">
        {{ thirdsection }}
      </div>
      <textarea
        v-if="editMode"
        class="editThirdSection"
        rows="5"
        cols="33"
        :placeholder="thirdsection"
        v-model="wantedThirdSection"
      />
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
    <Footer v-if="editMode" class="EditLoginFooter" />
    <Footer v-if="!editMode" class="loginFooter" />
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
      currentUsername: null,
      currentProfile:
        localStorage.getItem('profileURL') != null
          ? localStorage.getItem('profileURL')
          : '../images/profile.png',
      wantedMainTitle: '',
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
      wantedFirstTag: '',
      wantedSecondTag: '',
      wantedThirdTag: '',
      wantedFirstDescription: '',
      wantedSecondDescription: '',
      wantedThirdDescription: '',
      wantedFirstSection: '',
      wantedSecondSection: '',
      wantedThirdSection: '',
      wantedFirstPreReq: '',
      wantedSecondPreReq: '',
      wantedThirdPreReq: '',
      wantedDifficulty: '',
      wantedLanguage: '',
      wantedFirstTitle: '',
      wantedSecondTitle: '',
      wantedThirdTitle: '',
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
    if (localStorage.getItem('username') == this.author) {
      this.currentUsername = localStorage.getItem('username');
    }
  },
  watch: {},
  methods: {
    async deleteArticle() {
      let deleteDislikesRes = await fetch(
        '/rest/dislikes/deleteDislikesByArticleId/' + this.$route.params.id,
        {
          method: 'DELETE',
        }
      );

      let deleteLikesRes = await fetch(
        '/rest/likes/deleteLikesByArticleId/' + this.$route.params.id,
        {
          method: 'DELETE',
        }
      );

      let deleteArticleRes = await fetch(
        '/rest/articles/deleteArticle/' + this.$route.params.id,
        {
          method: 'DELETE',
        }
      );

      this.$router.push('/');
    },
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
    async saveChanges() {
      let res = await fetch(
        '/rest/articles/updateArticle/' +
          this.$route.params.id +
          '/' +
          (this.wantedMainTitle.length == 0
            ? this.maintitle
            : this.wantedMainTitle) +
          '/' +
          (this.wantedFirstTag.length == 0
            ? this.firstTag
            : this.wantedFirstTag) +
          '/' +
          (this.wantedSecondTag.length == 0
            ? this.secondTag
            : this.wantedSecondTag) +
          '/' +
          (this.wantedThirdTag.length == 0
            ? this.thirdTag
            : this.wantedThirdTag) +
          '/' +
          (this.wantedFirstPreReq.length == 0
            ? this.firstPreReq
            : this.wantedFirstPreReq) +
          '/' +
          (this.wantedSecondPreReq.length == 0
            ? this.secondPreReq
            : this.wantedSecondPreReq) +
          '/' +
          (this.wantedThirdPreReq.length == 0
            ? this.thirdPreReq
            : this.wantedThirdPreReq) +
          '/' +
          (this.wantedDifficulty.length == 0
            ? this.difficulty
            : this.wantedDifficulty) +
          '/' +
          (this.wantedLanguage.length == 0
            ? this.language
            : this.wantedLanguage) +
          '/' +
          (this.wantedFirstDescription.length == 0
            ? this.firstdescription
            : this.wantedFirstDescription) +
          '/' +
          (this.wantedFirstTitle.length == 0
            ? this.firsttitle
            : this.wantedFirstTitle) +
          '/' +
          (this.wantedFirstSection.length == 0
            ? this.firstsection
            : this.wantedFirstSection) +
          '/' +
          (this.wantedSecondDescription.length == 0
            ? this.seconddescription
            : this.wantedSecondDescription) +
          '/' +
          (this.wantedSecondTitle.length == 0
            ? this.secondtitle
            : this.wantedSecondTitle) +
          '/' +
          (this.wantedSecondSection.length == 0
            ? this.secondsection
            : this.wantedSecondSection) +
          '/' +
          (this.wantedThirdDescription.length == 0
            ? this.thirddescription
            : this.wantedThirdDescription) +
          '/' +
          (this.wantedThirdTitle.length == 0
            ? this.thirdtitle
            : this.wantedThirdTitle) +
          '/' +
          (this.wantedThirdSection.length == 0
            ? this.thirdsection
            : this.wantedThirdSection),
        {
          method: 'PUT',
        }
      );
      this.maintitle =
        this.wantedMainTitle.length == 0
          ? this.maintitle
          : this.wantedMainTitle;
      this.firstTag =
        this.wantedFirstTag.length == 0 ? this.firstTag : this.wantedFirstTag;
      this.secondTag =
        this.wantedSecondTag.length == 0
          ? this.secondTag
          : this.wantedSecondTag;
      this.thirdTag =
        this.wantedThirdTag.length == 0 ? this.thirdTag : this.wantedThirdTag;
      this.firstPreReq =
        this.wantedFirstPreReq.length == 0
          ? this.firstPreReq
          : this.wantedFirstPreReq;
      this.secondPreReq =
        this.wantedSecondPreReq.length == 0
          ? this.secondPreReq
          : this.wantedSecondPreReq;
      this.thirdPreReq =
        this.wantedThirdPreReq.length == 0
          ? this.thirdPreReq
          : this.wantedThirdPreReq;
      this.difficulty =
        this.wantedDifficulty.length == 0
          ? this.difficulty
          : this.wantedDifficulty;
      this.language =
        this.wantedLanguage.length == 0 ? this.language : this.wantedLanguage;
      this.firstdescription =
        this.wantedFirstDescription.length == 0
          ? this.firstdescription
          : this.wantedFirstDescription;
      this.firsttitle =
        this.wantedFirstTitle.length == 0
          ? this.firsttitle
          : this.wantedFirstTitle;
      this.firstsection =
        this.wantedFirstSection.length == 0
          ? this.firstsection
          : this.wantedFirstSection;
      this.seconddescription =
        this.wantedSecondDescription.length == 0
          ? this.seconddescription
          : this.wantedSecondDescription;
      this.secondtitle =
        this.wantedSecondTitle.length == 0
          ? this.secondtitle
          : this.wantedSecondTitle;
      this.secondsection =
        this.wantedSecondSection.length == 0
          ? this.secondsection
          : this.wantedSecondSection;
      this.thirddescription =
        this.wantedThirdDescription.length == 0
          ? this.thirddescription
          : this.wantedThirdDescription;
      this.thirdtitle =
        this.wantedThirdTitle.length == 0
          ? this.thirdtitle
          : this.wantedThirdTitle;
      this.thirdsection =
        this.wantedThirdSection.length == 0
          ? this.thirdsection
          : this.wantedThirdSection;
      let response = await res.json();
      this.editMode = false;
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
.editDifficultyInput {
  position: relative;
  left: 205px;
  top: -26px;
  padding-left: 5px;
  width: 120px;
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
.editThirdTagInput {
  padding-left: 5px;
  margin-left: 5px;
  width: 180px;
  position: absolute;
  top: 2px;
  left: 5px;
}
.mainDiv {
  height: 100%;
  background-color: #131313;
}
.firstDescription,
.secondDescription,
.thirdDescription {
  background-color: white;
  width: 314px;
  margin-left: auto;
  margin-right: auto;
  border: solid 1px black;
  border-radius: 10px;
  text-align: center;
  margin-top: 10px;
}

.editFirstDescription,
.editFirstSection,
.editSecondDescription,
.editSecondSection,
.editThirdDescription,
.editThirdSection {
  background-color: white;
  width: 314px;
  display: block;
  border: solid 1px black;
  border-radius: 10px;
  text-align: center;
  margin-top: 10px;
  margin-left: auto;
  margin-right: auto;
  padding-top: 3px;
  position: relative;
  top: -35px;
}

.bigGrid {
  display: grid;
  width: 100%;
  grid-template-columns: auto max-content auto max-content auto max-content auto max-content auto;
  position: relative;
  top: -2px;
}
.editSecondPreReqInput {
  position: absolute;
  top: 167px;
  left: 20px;
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

.editFirstPreReqInput {
  position: relative;
  left: 20px;
  top: -75px;
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
.secondTitle,
.thirdTitle {
  width: 100%;
  text-align: center;
  margin-top: 5px;
  text-decoration: underline;
  margin-bottom: 4px;
}

.editFirstTitle,
.editSecondTitle,
.editThirdTitle {
  margin-left: auto;
  margin-right: auto;
  width: max-content;
  display: block;
}

.editFirstTitleInput,
.editSecondTitleInput,
.editThirdTitleInput {
  width: 360px;
  margin-bottom: 5px;
  text-align: center;
  position: relative;
  top: -30px;
}

.firstsection,
.secondsection,
.thirdsection {
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
  right: -205px;
  width: 125px;
  top: -25px;
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
.editSecondPreReqDiv {
  position: relative;
  left: 20px;
  top: -73px;
}
.editThirdPreReqDiv {
  position: relative;
  left: 20px;
  top: -71px;
}
.editSecondPreReqInput,
.editThirdPreReqInput,
.editFirstPreReqInput {
  padding-left: 5px;
}

.editThirdPreReqInput {
  position: absolute;
  top: 184px;
  left: 20px;
  width: 170px;
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
  width: max-content;
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
  width: 290px;
}

.mainTitleInput {
  padding-left: 5px;
  width: 265px;
  border: solid 1px black;
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
  grid-template-columns: 15px max-content auto max-content auto max-content auto max-content auto max-content auto;
}

.preReqAndDifficultyGrid {
  display: grid;
  grid-template-columns: 15px max-content 106px max-content auto;
  margin-top: 5px;
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
  top: -25.5px;
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
  top: calc(100vh - 680px);
}

.EditLoginFooter {
  position: relative;
  top: calc(100vh - 771px);
}
</style>
