/* eslint-disable jsx-a11y/anchor-has-content */
import { ReactComponent as GithubIcon } from 'assets/img/github.svg'
import './styles.css'

function Navbar() {
    return (
        <header>
            <nav className="dsmovie-container container">
                <div className="dsmovie-nav-content">
                    <h1>DSMovie</h1>
                    <a href="https://github.com/alexandre-medeiros" />
                    <div className="dsmovie-contact-container">
                        <GithubIcon />
                        <p className='dsmovie-contact-link'>/alexandre-medeiros</p>
                    </div>
                </div>
            </nav>
        </header>

    );
}

export default Navbar;