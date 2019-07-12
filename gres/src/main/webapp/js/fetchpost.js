
const getPost = () =>{
fetch(``)
    .then(res => res.json())
    .then(post => console.log(posts))
}