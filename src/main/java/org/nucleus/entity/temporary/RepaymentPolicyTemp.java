package org.nucleus.entity.temporary;

import lombok.Data;
import org.nucleus.entity.meta.MetaData;
import org.nucleus.entity.meta.TempMetaData;
import org.nucleus.utility.enums.ContractType;
import org.nucleus.utility.enums.RecoveryType;
import org.nucleus.utility.enums.RepaymentFrequency;
import org.nucleus.utility.enums.RepaymentType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "REPAYMENT_POLICY_TEMP_TBL_BATCH_6")
@TableGenerator(name="ID_TEMP_TABLE_GEN_BATCH_6",pkColumnValue = "REPAYMENT_POLICY_TEMP_TBL_BATCH_6",initialValue=100000, allocationSize=1)
public class RepaymentPolicyTemp {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="ID_TEMP_TABLE_GEN_BATCH_6")
    private Long repaymentPolicyId;
    private String repaymentPolicyCode;
    private String repaymentPolicyName;
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
    @Enumerated(EnumType.STRING)
    private RepaymentType repaymentType;
    @Enumerated(EnumType.STRING)
    private RecoveryType recoveryType;
    private String installmentDueDate;
    @Enumerated(EnumType.STRING)
    private RepaymentFrequency repaymentFrequency;
    @Embedded
    private TempMetaData metaData;
}
