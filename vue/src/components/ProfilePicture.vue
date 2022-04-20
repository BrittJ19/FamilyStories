<template>
<div class="uploader">
    <input style="display: none" 
    type="file" 
    @change="onFileSelected"
    ref="fileInput">
    <button @click="$refs.fileInput.click()">Upload Profile Picture</button>
    <button @click="onUpload">Upload</button>
</div>
  
</template>

<script>
export default {
    name: 'picUploader',
    data() {
        return {
            selectedFile: null
        }
    },

    methods: {
        onFileSelected(event) {
            this.selectedFile = event.target.files[0]
        },
        onUpload() {
            const fd = new FormData();
            fd.append('image', this.selectedFile, this.selectedFile.name)
        }
    }
}
</script>

<style>

button{
    background-color: rgb(255,117,24);
    font-family: 'abeatbyKai', sans-serif;
    margin: 10px;
    margin-right: 0px;
    padding: 10px;
    color: rgb(245,245,220);
     -webkit-box-shadow: 0px 20px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 20px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 20px 20px rgba(50, 50, 50, 0.75);
}

</style>