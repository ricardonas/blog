import styled from 'styled-components';

const Container = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;

    .svg-img {
        position: absolute;
        transform: scale(0.5);
        top: -135px;
        left: 750px;
    }
`;

export const Form = styled.form`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 500px;
`;

export const Input = styled.input`
    text-indent: 15px;
    font-size: 14px;
    height: 40px;
    width: 100%;
    background-color: #fff;
    color: #000;
    border: none;
    transition: all 150ms ease-out 0s;
    box-shadow: 0px 0px 0px 1px #000;
    border-radius: 4px;
    outline: none;
    :hover {
        box-shadow: 0px 0px 0px 2px #005dff;
    }
`;

export const Label = styled.label`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    width: 100%;
    font-size: 14px;
    margin: 10px 0 8px 2px;
    color: #464646;
`;

export const Button = styled.button`
    height: 40px;
    width: 100%;
    padding: 10px 18px;
    margin: 20px 0px 0px 0px;
    background: #000;
    color: #fff;
    border-radius: 4px;
    outline: 0;
    border: 0;
    font-weight: 600;
    font-size: 15px;
    box-shadow: 0px 0px 0px 1px #000;
    cursor: pointer;
    :hover {
        box-shadow: 0px 0px 0px 2px #005dff;
    }
`;

export const Link = styled.a`
    color: #000;
    font-size: 16px;
    line-height: 1.5em;
    cursor: pointer;
    margin-top: 30px;
    text-decoration: underline;
    width: 100%;
    text-align: center;
`;

export default Container;
