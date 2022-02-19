<template>
  <div class="commentBox">
    <div class="imageNameDateGrid">
      <div class="Spaceblock" />
      <img class="posterImage" :src="authorImage" />
      <div class="Spaceblock" />
      <div class="Authorname">
        {{ comment.authorname }}
      </div>
      <div class="Spaceblock" />
      <div class="dateDiv">
        {{ date }}
      </div>
      <div class="Spaceblock" />
    </div>
    <div class="textDiv">
      {{ comment.content }}
    </div>
  </div>
</template>
<script>
import store from '../store';

export default {
  name: 'Comment',
  props: ['comment'],
  data() {
    return {
      authorImage: this.comment.authorurl,
      date: this.comment.timestamp,
    };
  },

  async mounted() {
    let offset = new Date().getTimezoneOffset() * -1;
    this.date = new Date(new Date(this.comment.timestamp).getTime() + offset)
      .toString()
      .substring(4, 25)
      .substring(0, 17);
  },

  methods: {},
};
</script>

<style scoped>
.Authorname,
.dateDiv {
  margin-top: 10px;
}
.commentBox {
  width: 350px;
  background-color: white;
  height: max-content;
  border-radius: 10px;
  display: block;
  margin-left: auto;
  margin-right: auto;
  padding-bottom: 13px;
  margin-bottom: 10px;
}

.posterImage {
  width: 30px;
  height: 30px;
  border-radius: 30px;
  margin-left: 5px;
  margin-top: 5px;
}
.imageNameDateGrid {
  display: grid;
  grid-template-columns: 10px max-content 10px auto 10px max-content 10px;
}
.textDiv {
  margin-left: 55px;
  max-width: 250px;
}
</style>
