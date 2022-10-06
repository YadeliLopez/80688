var msj_bot = {
    //propiedad -> algo que le pertenece al objeto
    saludo:"hola",
    despedida:"adiós",
    preocupacion:"cómo estás?",
    sorpresa:"orale!"
}

var arr_msj = ["hola", "adiós", "cómo estás?", "orale!"]

function test(){
    let mensajes = document.getElementById("msjs")
    //mensajes.innerHTML = msj_bot;
    //mensajes.innerHTML = arr_msj;
    mensajes.innerHTML = JSON.stringify(msj_bot);
}

function procesa(){
    let campo = document.getElementById("msj").value
    console.log(woz(campo))
    let mensajes = document.getElementById("msjs")
    mensajes.innerHTML = msj_bot[woz(campo)]
}

function woz(params){
    if(params == "hola")
    return "saludo"

    if(params == "me siento mal")
    return "sorpresa"

    if(params == "adios")
    return "despedida"

    if(params == "")
    return "preocupacion"
}