let spanList = document.querySelectorAll(".divEtiquette tbody td span.bg");

for(let span of spanList){
    span.style.background = span.getAttribute("content");
}