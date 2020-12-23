import { MOCK } from "./mock-data.js";

(function(data, document) {
    let keys = Object.keys( data[0] );

    function createTag(tag, content) {
        return `<${tag}>
        ${Array.isArray(content) ? content.join("") : content}
        </${tag}>`;
    }
    function createSingleTag(tag, prop, val) {
        return `<${tag} ${prop}="${val}"/>`;
    }
    
    const renderTr = createTag.bind(undefined, "tr");
    const renderTh = createTag.bind(undefined, "th");
    const renderTd = createTag.bind(undefined, "td");
    const renderUl = createTag.bind(undefined, "ul");
    const renderLi = createTag.bind(undefined, "li");
    const renderThead = createTag.bind(undefined, "thead");
    const renderTbody = createTag.bind(undefined, "tbody");
    const renderTable = createTag.bind(undefined, "table");

    function chooseContentType(map, defaultWrapper, type, content) {
        if( typeof map[type] === "function" ) {
            return defaultWrapper(map[type](type, content));
        }
        return defaultWrapper(content);
    }

    const fieldsMap = {
        avatar: (_, x) => createSingleTag('img', 'src', x),
        friends: (_, list) => renderUl(
            list.map( f => renderLi(`${f.first_name} ${f.last_name}`) )
        ),
        email: (_, x) => `<a href="mailto:${x}">${x}<a>`,
    }

    const headingsMap = 
            ["id", "first_name", "last_name", "email", "gender", "ip_address"]
            .reduce( (a, b) =>  {
                a[b] = (type, content) => {
                    return `<a class="filter" data-sortby="${type}">${content}<a>`
                   }
                return a
            }, {});

    const defaultTd = chooseContentType.bind(
        undefined,
        fieldsMap, renderTd
    );

    const defaultTh = chooseContentType.bind(
        undefined,
        headingsMap, renderTh 
    );


    const dict = {
        id: "Идент.",
        email: "Мейл",
        gender: "Пол",
        ip_address: "IP",
        avatar: "Картинка",
        friends: "Приятели",
        first_name: "Име",
        last_name: "Фамилия",
    }

    function main(data) {
        return renderTable(
            renderThead( renderTr(
                keys.map(key => defaultTh(key, dict[key]))
                )
            ) 
            +
            renderTbody(
                data.map(
                    row => renderTr(
                        keys.map(
                            cell => defaultTd(cell, row[cell]
                            )
                        )
                    )
                )
            )
        );
    }
    
    function addToHtml(data) {
        document.getElementById('app').innerHTML = main(data);
    }

    addToHtml(data);

    function sortby(key, a, b){
        if(typeof a[key] === "number"){
            return a[key] - b[key];
        }
        return a[key].localeCompare(b[key]);
    }
    
    document.addEventListener('click', function(evt) {
        if(evt.target.classList.contains('filter')){
            addToHtml(
                data.sort(sortby.bind(undefined, evt.target.dataset.sortby))
            )
        }
    }, true)
}(MOCK.slice(0, 20), document));