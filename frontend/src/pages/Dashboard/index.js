import React, { useState, useEffect } from 'react';
import { IoLogoWhatsapp } from 'react-icons/io';
import { TiDelete } from 'react-icons/ti';
import api from '../../services/api';

import { Container, PostContainer } from './styles';

function Dashboard() {
    const [data, setData] = useState([]);

    const auth = {
        username: 'ricardo@gmail.com',
        password: '123456',
    };

    let props = {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        auth,
    };

    useEffect(() => {
        api.get('posts', { ...props })
            .then((respose) => {
                setData(respose.data);
            })
            .catch((err) => console.log(err));
    });

    return (
        <Container>
            <a>Criar post</a>
            <a>Meus posts</a>

            {data.map((item, index) => (
                <PostContainer key={index}>
                    <h1>{item.title}</h1>
                    <p>{item.text}</p>
                    <small>Author: Ricardo</small>
                    <small>{item.post_date}</small>
                    <a
                        href={`https://api.whatsapp.com/send?text=${item.title}%0a${item.text}`}
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        <IoLogoWhatsapp size="20px" />
                    </a>

                    <a href={`http://localhost:8080/${item.id}`}>
                        <TiDelete size="20px" />
                    </a>
                </PostContainer>
            ))}
        </Container>
    );
}

export default Dashboard;
