function id_f091cb92_683e_4b3d_a1b3_474d7ab95248() {
    return true;
}
function id_6f8e3cf0_d28d_4005_be14_2089c6061cda() {
    return false;
}
function id_cbc1faf9_0522_4dca_bdc1_825b7a627eff() {
    return false;
}
function id_b1ed36a5_7821_4d9f_bb16_f417fe033531() {
    return false;
}
function id_81cf3ba1_a61b_4059_be35_aa4264acddd0() {
    var id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b = new id_47d36464_cafa_408c_8a66_5b9b649b227e();
    var id_6e1aa896_1589_452b_94e2_780787a7b393 = new id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(null, ID_WORKER, KIND_WORK);
    var id_ba123ef2_cece_47e4_80e7_e2f48986b49c = 'Error during execution: queueCount = ' + id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.queueCount + ', holdCount = ' + id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.holdCount + '.';
    var id_b4b0a052_e6f7_44a8_abcf_18d48d8b10b0 = 'id_567dd63b_7053_4e4e_beba_83172028f275';
    while (id_b4b0a052_e6f7_44a8_abcf_18d48d8b10b0 != 'id_bd82ec44_4186_4432_b0cb_357e8ae31e31') {
        switch (id_b4b0a052_e6f7_44a8_abcf_18d48d8b10b0) {
        case 'id_567dd63b_7053_4e4e_beba_83172028f275':
            id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.addIdleTask(ID_IDLE, 0, null, COUNT);
            id_6e1aa896_1589_452b_94e2_780787a7b393 = new id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(id_6e1aa896_1589_452b_94e2_780787a7b393, ID_WORKER, KIND_WORK);
            id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.addWorkerTask(ID_WORKER, 1000, id_6e1aa896_1589_452b_94e2_780787a7b393);
            id_6e1aa896_1589_452b_94e2_780787a7b393 = new id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(null, ID_DEVICE_A, KIND_DEVICE);
            id_6e1aa896_1589_452b_94e2_780787a7b393 = new id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(id_6e1aa896_1589_452b_94e2_780787a7b393, ID_DEVICE_A, KIND_DEVICE);
            id_6e1aa896_1589_452b_94e2_780787a7b393 = new id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(id_6e1aa896_1589_452b_94e2_780787a7b393, ID_DEVICE_A, KIND_DEVICE);
            id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.addHandlerTask(ID_HANDLER_A, 2000, id_6e1aa896_1589_452b_94e2_780787a7b393);
            id_6e1aa896_1589_452b_94e2_780787a7b393 = new id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(null, ID_DEVICE_B, KIND_DEVICE);
            id_6e1aa896_1589_452b_94e2_780787a7b393 = new id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(id_6e1aa896_1589_452b_94e2_780787a7b393, ID_DEVICE_B, KIND_DEVICE);
            id_6e1aa896_1589_452b_94e2_780787a7b393 = new id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(id_6e1aa896_1589_452b_94e2_780787a7b393, ID_DEVICE_B, KIND_DEVICE);
            id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.addHandlerTask(ID_HANDLER_B, 3000, id_6e1aa896_1589_452b_94e2_780787a7b393);
            id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.addDeviceTask(ID_DEVICE_A, 4000, null);
            id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.addDeviceTask(ID_DEVICE_B, 5000, null);
            id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.schedule();
            id_b4b0a052_e6f7_44a8_abcf_18d48d8b10b0 = 'id_c33e79b7_08d7_4472_8fd5_df50b3e09902';
            break;
        case 'id_c33e79b7_08d7_4472_8fd5_df50b3e09902':
            if (id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.queueCount != EXPECTED_QUEUE_COUNT || id_c53f19ae_24ac_4e3c_bc14_d55c9bf32a8b.holdCount != EXPECTED_HOLD_COUNT)
                id_b4b0a052_e6f7_44a8_abcf_18d48d8b10b0 = 'id_58ffff44_dc78_42c2_9ede_017c7ba37c58';
            else
                id_b4b0a052_e6f7_44a8_abcf_18d48d8b10b0 = 'id_4a617a48_ce39_418f_8acb_0d4161ef94f9';
            break;
        case 'id_58ffff44_dc78_42c2_9ede_017c7ba37c58':
            throw new Error(id_ba123ef2_cece_47e4_80e7_e2f48986b49c);
            id_b4b0a052_e6f7_44a8_abcf_18d48d8b10b0 = 'id_bd82ec44_4186_4432_b0cb_357e8ae31e31';
            break;
        case 'id_4a617a48_ce39_418f_8acb_0d4161ef94f9':
            id_b4b0a052_e6f7_44a8_abcf_18d48d8b10b0 = 'id_bd82ec44_4186_4432_b0cb_357e8ae31e31';
            break;
        }
    }
}
var COUNT = 1000;
var EXPECTED_QUEUE_COUNT = 2322;
var EXPECTED_HOLD_COUNT = 928;
function id_47d36464_cafa_408c_8a66_5b9b649b227e() {
    var id_16516029_7da6_43ba_8220_b04d3cce1799 = 'id_46cc83de_c271_408f_befb_7577142150e7';
    while (id_16516029_7da6_43ba_8220_b04d3cce1799 != 'id_07036e3f_326c_433c_8adc_6e4a70b9f72f') {
        switch (id_16516029_7da6_43ba_8220_b04d3cce1799) {
        case 'id_46cc83de_c271_408f_befb_7577142150e7':
            this.queueCount = 0;
            this.holdCount = 0;
            this.blocks = new Array(NUMBER_OF_IDS);
            this.list = null;
            this.currentTcb = null;
            this.currentId = null;
            id_16516029_7da6_43ba_8220_b04d3cce1799 = 'id_07036e3f_326c_433c_8adc_6e4a70b9f72f';
            break;
        }
    }
}
var ID_IDLE = 0;
var ID_WORKER = 1;
var ID_HANDLER_A = 2;
var ID_HANDLER_B = 3;
var ID_DEVICE_A = 4;
var ID_DEVICE_B = 5;
var NUMBER_OF_IDS = 6;
var KIND_DEVICE = 0;
var KIND_WORK = 1;
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.addIdleTask = function (id, priority, queue, count) {
    this.addRunningTask(id, priority, queue, new id_4230bcc4_24de_4886_9f06_f278179c5ac2(this, 1, count));
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.addWorkerTask = function (id, priority, queue) {
    this.addTask(id, priority, queue, new id_904f6ab3_8d9c_4c82_9033_890887c53764(this, ID_HANDLER_A, 0));
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.addHandlerTask = function (id, priority, queue) {
    this.addTask(id, priority, queue, new id_efb2c739_e6be_4344_a8a2_704b4e1ff0c1(this));
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.addDeviceTask = function (id, priority, queue) {
    this.addTask(id, priority, queue, new id_69b93b28_0d9d_4387_b9aa_f8a4f83264a3(this));
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.addRunningTask = function (id, priority, queue, task) {
    this.addTask(id, priority, queue, task);
    this.currentTcb.setRunning();
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.addTask = function (id, priority, queue, task) {
    this.currentTcb = new id_fd06d053_048d_49d7_b660_9fb0435bda27(this.list, id, priority, queue, task);
    this.list = this.currentTcb;
    this.blocks[id] = this.currentTcb;
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.schedule = function () {
    this.currentTcb = this.list;
    while (this.currentTcb != null) {
        if (this.currentTcb.isHeldOrSuspended()) {
            this.currentTcb = this.currentTcb.link;
        } else {
            this.currentId = this.currentTcb.id;
            this.currentTcb = this.currentTcb.run();
        }
    }
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.release = function (id) {
    var tcb = this.blocks[id];
    if (tcb == null)
        return tcb;
    tcb.markAsNotHeld();
    if (tcb.priority > this.currentTcb.priority) {
        return tcb;
    } else {
        return this.currentTcb;
    }
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.holdCurrent = function () {
    this.holdCount++;
    this.currentTcb.markAsHeld();
    return this.currentTcb.link;
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.suspendCurrent = function () {
    this.currentTcb.markAsSuspended();
    return this.currentTcb;
};
id_47d36464_cafa_408c_8a66_5b9b649b227e.prototype.queue = function (packet) {
    var t = this.blocks[packet.id];
    if (t == null)
        return t;
    this.queueCount++;
    packet.link = null;
    packet.id = this.currentId;
    return t.checkPriorityAdd(this.currentTcb, packet);
};
function id_fd06d053_048d_49d7_b660_9fb0435bda27(link, id, priority, queue, task) {
    var id_14c4fdbd_cc66_4d64_b442_e956dbe2296c = 'id_769c9c75_64a1_4345_a374_f67109eedb8f';
    while (id_14c4fdbd_cc66_4d64_b442_e956dbe2296c != 'id_f8b8aeea_936f_4893_b0c3_7da9aed33c70') {
        switch (id_14c4fdbd_cc66_4d64_b442_e956dbe2296c) {
        case 'id_769c9c75_64a1_4345_a374_f67109eedb8f':
            this.link = link;
            this.id = id;
            this.priority = priority;
            this.queue = queue;
            this.task = task;
            id_14c4fdbd_cc66_4d64_b442_e956dbe2296c = 'id_ded687bc_f833_4dd6_b254_22188e48054c';
            break;
        case 'id_ded687bc_f833_4dd6_b254_22188e48054c':
            if (queue == null)
                id_14c4fdbd_cc66_4d64_b442_e956dbe2296c = 'id_539b9bc1_8686_4fe9_b616_e59790dd6a7a';
            else
                id_14c4fdbd_cc66_4d64_b442_e956dbe2296c = 'id_3479233a_8842_4f8a_b599_9c0e85389ba8';
            break;
        case 'id_539b9bc1_8686_4fe9_b616_e59790dd6a7a':
            this.state = STATE_SUSPENDED;
            id_14c4fdbd_cc66_4d64_b442_e956dbe2296c = 'id_f8b8aeea_936f_4893_b0c3_7da9aed33c70';
            break;
        case 'id_3479233a_8842_4f8a_b599_9c0e85389ba8':
            this.state = STATE_SUSPENDED_RUNNABLE;
            id_14c4fdbd_cc66_4d64_b442_e956dbe2296c = 'id_f8b8aeea_936f_4893_b0c3_7da9aed33c70';
            break;
        }
    }
}
var STATE_RUNNING = 0;
var STATE_RUNNABLE = 1;
var STATE_SUSPENDED = 2;
var STATE_HELD = 4;
var STATE_SUSPENDED_RUNNABLE = STATE_SUSPENDED | STATE_RUNNABLE;
var STATE_NOT_HELD = ~STATE_HELD;
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.setRunning = function () {
    this.state = STATE_RUNNING;
};
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.markAsNotHeld = function () {
    this.state = this.state & STATE_NOT_HELD;
};
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.markAsHeld = function () {
    this.state = this.state | STATE_HELD;
};
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.isHeldOrSuspended = function () {
    return (this.state & STATE_HELD) != 0 || this.state == STATE_SUSPENDED;
};
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.markAsSuspended = function () {
    this.state = this.state | STATE_SUSPENDED;
};
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.markAsRunnable = function () {
    this.state = this.state | STATE_RUNNABLE;
};
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.run = function () {
    var packet;
    if (this.state == STATE_SUSPENDED_RUNNABLE) {
        packet = this.queue;
        this.queue = packet.link;
        if (this.queue == null) {
            this.state = STATE_RUNNING;
        } else {
            this.state = STATE_RUNNABLE;
        }
    } else {
        packet = null;
    }
    return this.task.run(packet);
};
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.checkPriorityAdd = function (task, packet) {
    if (this.queue == null) {
        this.queue = packet;
        this.markAsRunnable();
        if (this.priority > task.priority)
            return this;
    } else {
        this.queue = packet.addTo(this.queue);
    }
    return task;
};
id_fd06d053_048d_49d7_b660_9fb0435bda27.prototype.toString = function () {
    return 'tcb { ' + this.task + '@' + this.state + ' }';
};
function id_4230bcc4_24de_4886_9f06_f278179c5ac2(scheduler, v1, count) {
    var id_668d5d9d_ae88_411f_8145_ad5e5360796f = 'id_fca9aec2_79e2_4142_9ea1_c60e3f1426e4';
    while (id_668d5d9d_ae88_411f_8145_ad5e5360796f != 'id_4e0182c6_a6f7_4c7a_b4aa_4adf69fe9c5e') {
        switch (id_668d5d9d_ae88_411f_8145_ad5e5360796f) {
        case 'id_fca9aec2_79e2_4142_9ea1_c60e3f1426e4':
            this.scheduler = scheduler;
            this.v1 = v1;
            this.count = count;
            id_668d5d9d_ae88_411f_8145_ad5e5360796f = 'id_4e0182c6_a6f7_4c7a_b4aa_4adf69fe9c5e';
            break;
        }
    }
}
id_4230bcc4_24de_4886_9f06_f278179c5ac2.prototype.run = function (packet) {
    this.count--;
    if (this.count == 0)
        return this.scheduler.holdCurrent();
    if ((this.v1 & 1) == 0) {
        this.v1 = this.v1 >> 1;
        return this.scheduler.release(ID_DEVICE_A);
    } else {
        this.v1 = this.v1 >> 1 ^ 53256;
        return this.scheduler.release(ID_DEVICE_B);
    }
};
id_4230bcc4_24de_4886_9f06_f278179c5ac2.prototype.toString = function () {
    return 'IdleTask';
};
function id_69b93b28_0d9d_4387_b9aa_f8a4f83264a3(scheduler) {
    var id_2d43bd63_2386_47df_859b_8ff022f7ff61 = 'id_229859c7_67e4_4d11_af0b_e074ac64e747';
    while (id_2d43bd63_2386_47df_859b_8ff022f7ff61 != 'id_50a7bf4a_c3ed_431a_9317_bc831a90c2d1') {
        switch (id_2d43bd63_2386_47df_859b_8ff022f7ff61) {
        case 'id_229859c7_67e4_4d11_af0b_e074ac64e747':
            this.scheduler = scheduler;
            this.v1 = null;
            id_2d43bd63_2386_47df_859b_8ff022f7ff61 = 'id_50a7bf4a_c3ed_431a_9317_bc831a90c2d1';
            break;
        }
    }
}
id_69b93b28_0d9d_4387_b9aa_f8a4f83264a3.prototype.run = function (packet) {
    if (packet == null) {
        if (this.v1 == null)
            return this.scheduler.suspendCurrent();
        var v = this.v1;
        this.v1 = null;
        return this.scheduler.queue(v);
    } else {
        this.v1 = packet;
        return this.scheduler.holdCurrent();
    }
};
id_69b93b28_0d9d_4387_b9aa_f8a4f83264a3.prototype.toString = function () {
    return 'DeviceTask';
};
function id_904f6ab3_8d9c_4c82_9033_890887c53764(scheduler, v1, v2) {
    var id_522a42b0_d0c0_4267_987f_aed7e03f09af = 'id_f92cc6c4_0f8e_4d12_882f_89a1cd3b7d10';
    while (id_522a42b0_d0c0_4267_987f_aed7e03f09af != 'id_3ae4bdd4_498e_43a9_9c1d_e5ec08bf4db0') {
        switch (id_522a42b0_d0c0_4267_987f_aed7e03f09af) {
        case 'id_f92cc6c4_0f8e_4d12_882f_89a1cd3b7d10':
            this.scheduler = scheduler;
            this.v1 = v1;
            this.v2 = v2;
            id_522a42b0_d0c0_4267_987f_aed7e03f09af = 'id_3ae4bdd4_498e_43a9_9c1d_e5ec08bf4db0';
            break;
        }
    }
}
id_904f6ab3_8d9c_4c82_9033_890887c53764.prototype.run = function (packet) {
    if (packet == null) {
        return this.scheduler.suspendCurrent();
    } else {
        if (this.v1 == ID_HANDLER_A) {
            this.v1 = ID_HANDLER_B;
        } else {
            this.v1 = ID_HANDLER_A;
        }
        packet.id = this.v1;
        packet.a1 = 0;
        for (var i = 0; i < DATA_SIZE; i++) {
            this.v2++;
            if (this.v2 > 26)
                this.v2 = 1;
            packet.a2[i] = this.v2;
        }
        return this.scheduler.queue(packet);
    }
};
id_904f6ab3_8d9c_4c82_9033_890887c53764.prototype.toString = function () {
    return 'WorkerTask';
};
function id_efb2c739_e6be_4344_a8a2_704b4e1ff0c1(scheduler) {
    var id_1113eda2_dc1f_40cf_beaa_3d2051d972b8 = 'id_fb5f6048_6c1f_4ac8_91b7_dbafe6aa8768';
    while (id_1113eda2_dc1f_40cf_beaa_3d2051d972b8 != 'id_64585eb2_a123_4b8d_ad9b_be0c3db4b0fa') {
        switch (id_1113eda2_dc1f_40cf_beaa_3d2051d972b8) {
        case 'id_fb5f6048_6c1f_4ac8_91b7_dbafe6aa8768':
            this.scheduler = scheduler;
            this.v1 = null;
            this.v2 = null;
            id_1113eda2_dc1f_40cf_beaa_3d2051d972b8 = 'id_64585eb2_a123_4b8d_ad9b_be0c3db4b0fa';
            break;
        }
    }
}
id_efb2c739_e6be_4344_a8a2_704b4e1ff0c1.prototype.run = function (packet) {
    if (packet != null) {
        if (packet.kind == KIND_WORK) {
            this.v1 = packet.addTo(this.v1);
        } else {
            this.v2 = packet.addTo(this.v2);
        }
    }
    if (this.v1 != null) {
        var count = this.v1.a1;
        var v;
        if (count < DATA_SIZE) {
            if (this.v2 != null) {
                v = this.v2;
                this.v2 = this.v2.link;
                v.a1 = this.v1.a2[count];
                this.v1.a1 = count + 1;
                return this.scheduler.queue(v);
            }
        } else {
            v = this.v1;
            this.v1 = this.v1.link;
            return this.scheduler.queue(v);
        }
    }
    return this.scheduler.suspendCurrent();
};
id_efb2c739_e6be_4344_a8a2_704b4e1ff0c1.prototype.toString = function () {
    return 'HandlerTask';
};
var DATA_SIZE = 4;
function id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c(link, id, kind) {
    var id_e132d473_5804_4723_a153_c59762098e72 = 'id_c48033f7_06e9_4f87_8c81_0fe750749750';
    while (id_e132d473_5804_4723_a153_c59762098e72 != 'id_e1804004_b0e9_4332_a9e2_46fd51f62730') {
        switch (id_e132d473_5804_4723_a153_c59762098e72) {
        case 'id_c48033f7_06e9_4f87_8c81_0fe750749750':
            this.link = link;
            this.id = id;
            this.kind = kind;
            this.a1 = 0;
            this.a2 = new Array(DATA_SIZE);
            id_e132d473_5804_4723_a153_c59762098e72 = 'id_e1804004_b0e9_4332_a9e2_46fd51f62730';
            break;
        }
    }
}
id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c.prototype.addTo = function (queue) {
    this.link = null;
    if (queue == null)
        return this;
    var peek, next = queue;
    while ((peek = next.link) != null)
        next = peek;
    next.link = this;
    return queue;
};
id_6d06c2bd_3f5a_4a7d_ac67_530f9103b89c.prototype.toString = function () {
    return 'Packet';
};
class Benchmark {
    runIteration() {
        let iterations = 100000;
        console.log('Running richards.js for ' + iterations + ' iterations.');
        for (let i = 0; i < iterations; ++i)
            id_81cf3ba1_a61b_4059_be35_aa4264acddd0();
        console.time('richards');
        for (let i = 0; i < iterations; ++i)
            id_81cf3ba1_a61b_4059_be35_aa4264acddd0();
        console.timeEnd('richards');
        console.log('richards.js finished running');
    }
}
let bench = new Benchmark();
bench.runIteration();