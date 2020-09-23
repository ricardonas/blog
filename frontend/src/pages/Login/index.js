import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import { ReactSVG } from 'react-svg';
import { default as man } from '../../assets/man.svg';

import Container, {
    Input,
    Label,
    Button,
    Form,
    Link,
} from './styles';

import api from '../../services/api';

const Login = () => {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    let auth = { username, password };
    let history = useHistory();

    const handleData = async (e) => {
        e.preventDefault();

        try {
            await api.get('users', { auth });
            localStorage.setItem('user', auth.username);
            history.push('dashboard');
        } catch (e) {
            console.log(e);
        }
    };

    return (
        <Container>
            <ReactSVG src={man} className="svg-img"></ReactSVG>

            <Form type="submit" onSubmit={(e) => handleData(e)}>
                <Label htmlFor="user_email">Email</Label>
                <Input
                    type="email"
                    value={username}
                    onChange={(u) => setUsername(u.target.value)}
                    id="user_email"
                ></Input>

                <Label htmlFor="user_password">Senha</Label>
                <Input
                    type="password"
                    value={password}
                    onChange={(p) => setPassword(p.target.value)}
                    id="user_password"
                ></Input>

                <Button>Login</Button>

                <Link>Criar conta</Link>
            </Form>
        </Container>
    );
};

export default Login;
