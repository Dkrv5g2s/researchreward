function setReadOnly(flags){
    if (flags == true){
        $("input").prop("disabled",true);
        $("input[type='button']").prop("disabled",false);
        $("textarea").prop("disabled",true);
        $("button").remove();
        $("select").prop("disabled",true);
    }else{
        //don't need set readonly
    }
}