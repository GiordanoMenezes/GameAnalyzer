import React from 'react';
<<<<<<< HEAD
import { Link } from 'react-router-dom';
=======
>>>>>>> c50a494d8e20fda36d3d31b48fc35c6e8c44aa17

import { ReactComponent as ArrowRight } from '../../assets/images/arrowright.svg';
import { ReactComponent as GamerImg } from '../../assets/images/gamer.svg';

import './Home.css';

function Home() {
  return (
    <div className="home-container">
      <div className="home-text">
        <h1 className="home-text-title">
          Quais jogos a galera gosta mais?
        </h1>
        <h3 className="home-text-subtitle">
          Clique no botão abaixo e saiba quais são os jogos que os gamers estão escolhendo
        </h3>
        <div className="home-actions">
<<<<<<< HEAD
          <Link to="/records">
            <button className="home-btn">Quero Saber quais são</button>
            <div className="home-btn-icon">
              <ArrowRight />
            </div>
          </Link>
=======
          <button className="home-btn">Quero Saber quais são</button>
          <div className="home-btn-icon">
            <ArrowRight />
          </div>
>>>>>>> c50a494d8e20fda36d3d31b48fc35c6e8c44aa17
        </div>
      </div>
      <GamerImg className="home-image" />
    </div>
  );
}

export default Home;