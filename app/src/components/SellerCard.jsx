
import styles from '../Sellercard.module.css';

const Sellercard = ({ title,firstname, surname, address, postcode, phone }) => {

  return (
    <div className="item-card">
    <div className={styles.wrapper}>
      <p className={styles.title}>{title} {firstname} {surname}</p>
      <p className={styles.address}>{address} {postcode} {phone}</p>
      {/* <h3 className={styles.firstname} ></h3>
      <h3 className={styles.surname}>{surname}</h3>

      <p className={styles.address}>{address} {postcode} {phone}</p>
      <p className={styles.postcode}>{postcode}</p>
      <p className={styles.phone}>{phone}</p> */}
    </div>
    </div>
  )
}

export default Sellercard;