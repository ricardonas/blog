import React, { useState } from 'react';
import api from '../../services/api';

const Login = () => {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    const handleData = async (e) => {
        e.preventDefault();

        var config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            auth: {
                username,
                password,
            },
        };

        api.get(config)
            .then(function (response) {
                console.log(JSON.stringify(response.data));
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    return (
        <div className="input-group mb-3">
            <form
                className="input-group-prepend"
                onSubmit={(e) => handleData(e)}
            >
                <input
                    type="text"
                    placeholder="email"
                    name="email"
                    id="user_email"
                    className="form-control"
                    value={username}
                    onChange={(username) => {
                        setUsername(username.target.value);
                    }}
                />
                <input
                    type="password"
                    placeholder="senha"
                    name="password"
                    id="user_password"
                    className="form-control"
                    value={password}
                    onChange={(password) => {
                        setPassword(password.target.value);
                    }}
                />
                <button type="submit" className="btn btn-primary">
                    Login
                </button>
            </form>
        </div>
    );
};

export default Login;
