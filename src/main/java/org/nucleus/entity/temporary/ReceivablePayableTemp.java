package org.nucleus.entity.temporary;

import lombok.Data;
import org.nucleus.entity.meta.MetaData;
import org.nucleus.entity.meta.TempMetaData;
import org.nucleus.entity.permanent.LoanAccount;
import org.nucleus.utility.enums.Currency;
import org.nucleus.utility.enums.ReceivablePayableStatus;
import org.nucleus.utility.enums.ReceivablePayableType;
import org.nucleus.utility.enums.RecordStatus;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "RECEIVABLE_PAYABLE_TEMP_TBL_BATCH_6")
@TableGenerator(name="ID_TEMP_TABLE_GEN_BATCH_6",pkColumnValue = "RECEIVABLE_PAYABLE_TEMP_TBL_BATCH_6",initialValue=100000, allocationSize=1)
public class ReceivablePayableTemp {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="ID_TEMP_TABLE_GEN_BATCH_6")
    private Long receivablePayableId;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private ReceivablePayableType receivablePayableType;

    private Date receivablePayableDueDate;

    @ManyToOne
    @JoinColumn(name = "loanAccountId")
    private LoanAccount loanAccount;

    private Double receivablePayableAmount;
    private Double principalComponent;
    private Double principalComponentReceived;
    private Double interestComponent;
    private Double interestComponentReceived;
    private Date receivablePayableDate;

    @Enumerated(EnumType.STRING)
    private ReceivablePayableStatus receivablePayableStatus;

    private Double penalty;

    @Embedded
    private TempMetaData metaData;
}
