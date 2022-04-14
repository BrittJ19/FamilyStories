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
}

</style>