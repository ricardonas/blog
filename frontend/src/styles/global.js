import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`
    html {
        font-size: 62.5%;
        user-select: none;
    }
    body {
        margin: 0;
        padding: 0;
        font-family: 'Roboto', sans-serif;
    }
    * {
        margin: 0;
        padding: 0;
    }
`;
