package scorex.transaction.state.database.state.extension

import scorex.transaction.ValidationError.StateValidationError
import scorex.transaction.{GenesisTransaction, Transaction, ValidationError}

class GenesisValidator extends Validator {

  override def isValid(tx: Transaction, height: Int): Either[ValidationError,Transaction] = tx match {
    case gtx: GenesisTransaction if height != 0 => Left(StateValidationError("GenesisTranaction cannot appear in non-initial block"))
    case _ => Right(tx)
  }

  override def process(tx: Transaction, blockTs: Long, height: Int): Unit = {}
}