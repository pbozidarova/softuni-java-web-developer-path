import { html } from '../node_modules/lit-html/lit-html.js';

const loggedInLinks = html `
<a href="/create">Create</a>
<a href="/logout">Logout</a>
`;

export default ({
    navigationHandler,
    isAuthenticated,
    email,

    }) => html`
 <!-- Header -->
 <header @click=${navigationHandler}>
        <h1><a class="home" href="/">SoftWiki</a></h1>
        <nav class="nav-buttons">
            ${isAuthenticated 
                ? loggedInLinks
            : html`<a href="/register">Register</a>`
            }
        </nav>
 </header>
`;
