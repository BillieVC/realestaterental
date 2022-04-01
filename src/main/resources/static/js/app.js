function test(){
    loadProperty();
}

async function loadProperty(){

    const request = await fetch('/property', {
        method: 'GET',
        headers: getHeaders()
    });
    const property = await request.json();
    console.log(property.propertyList)
    const propertyList = property.propertyList;
    let cards='';
    for(let prop of propertyList){
        const requestFiles = await fetch('/files/'+prop.id, {
            method: 'GET',
            headers: getHeaders()
        });
        const files = await requestFiles.json();
        var srcImg = "https://upload.wikimedia.org/wikipedia/commons/d/d1/Image_not_available.png";
        if(files.files.length>0){
            const fileObj = files.files[0];
            srcImg = "data:"+fileObj.mimeType+";base64," + fileObj.value;
        }

      let cardHtml='<div class="col">\n' +
          '                <div class="card h-30 transition-content" style="cursor: pointer; ">' +
          '                    <h5 class="card-title" style="padding-left: 2%; padding-top: 2%;">'+prop.description+'</h5>' +
          '                    <div class="row g-0">' +
          '                        <div class="col-md-8">' +
          '                            <img src='+srcImg+
          '                            class="img-fluid rounded-start" alt="..." height="230" width="250" style="padding: 5%;">' +
          '                        </div>' +
          '                        <div class="col-md-4">' +
          '                            <div class="card-body">' +

          '                            <p class="card-text">'+prop.price+' bs/Mes</p>' +
          '                            <p class="card-text"> <small>'+prop.zone+'</small> </p>' +
          '                            <p class="card-text"><small class="text-muted">Cel: '+prop.contactInfo+'</small></p>' +
          '                            </div>' +
          '                        </div>' +
          '                        <div class="card-footer">' +
          '                            <small class="text-muted">Publicado en: '+prop.publicationDate+'</small>' +
          '                        </div>' +
          '                    </div>' +
          '                </div>' +
          '            </div>';
        cards+=cardHtml;
    }
    document.querySelector('#mycards container').outerHTML = cards;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    };
}