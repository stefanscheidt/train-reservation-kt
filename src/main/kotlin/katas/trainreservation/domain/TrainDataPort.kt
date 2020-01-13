package katas.trainreservation.domain

interface TrainDataPort {

    fun getTrainData(trainId: TrainId): TrainData?
}
