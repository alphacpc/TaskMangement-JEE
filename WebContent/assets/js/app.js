let btnClosed = document.querySelector(".closeForm")
let openForm = document.querySelector(".openForm")

btnClosed && btnClosed.addEventListener("click", ()=> {
    document.querySelector("form").setAttribute("method", "post")
    document.querySelector("form").removeAttribute("method")
    document.querySelector("form").removeAttribute("action")

    document.querySelector(".divOverlay").style.display = "none"
})


openForm && openForm.addEventListener("click", ()=> {

    document.querySelector(".divOverlay").style.display = "flex"
})