async function setPrint(){
    await removeIframeElements();
    await reinitIframe();
    window.setTimeout("window.print()", 500);
}

function removeIframeElements(){
    for(let i=0; i<iframeList.length; i++){
        const iframe = iframeList.item(i);
        removeButtons(iframe);
    }
}

function reinitIframe(){
    try{
        for(let i=0; i<iframeList.length; i++){
            const iframe = iframeList.item(i);
            const bHeight = iframe.contentWindow.document.body.scrollHeight;
            const dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
            iframe.height = String(Math.max(bHeight, dHeight));
        }
    }catch (ex){}
}
function removeButtons(iframe){
    let buttonList = iframe.contentWindow.document.getElementsByTagName("button");
    let inputButtonList = iframe.contentWindow.document.querySelectorAll("input[type=button]");
    let inputList = iframe.contentWindow.document.getElementsByTagName("input");
    let textareaList = iframe.contentWindow.document.getElementsByTagName("textarea");
    removeElements(buttonList);
    removeElements(inputButtonList);

    for(let i=0; i<inputList.length; i++){
        inputList[i].disabled=true;
    }
    for(let i=0; i<textareaList.length; i++){
        textareaList[i].disabled=true;
    }
}
function removeElements(list){
    for(let i=0; i<list.length; i++){
        list[i].style.display="none";
    }
}
