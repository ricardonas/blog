import styled from 'styled-components';

export const Container = styled.div`
    padding: 10px;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    box-sizing: border-box;
`;

export const PostContainer = styled.div`
    width: 700px;
    margin: 10px;
    padding: 20px;
    box-sizing: border-box;
    border: 1px solid black;

    h1 {
        display: block;
        font-size: 28px;
    }

    p {
        display: block;
        font-size: 14px;
    }

    small {
        margin-top: 10px;
        display: inline-block;
        font-size: 14px;
    }
`;
