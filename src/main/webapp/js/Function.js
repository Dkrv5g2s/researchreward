function setReadOnly(flags){
    if (flags == true){
        $("input").prop("readonly",true);
        $("textarea").prop("readonly",true);
        $("button").remove();
    }else{
        //don't need set readonly
    }
}